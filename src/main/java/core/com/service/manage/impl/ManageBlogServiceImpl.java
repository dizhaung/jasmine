package core.com.service.manage.impl;

import core.com.control.manage.BlogController;
import core.com.dao.BlogLoanDao;
import core.com.dao.ConfigBlogMarkDao;
import core.com.exception.CoreException;
import core.com.model.BlogLoan;
import core.com.model.BlogLoanWithBLOBs;
import core.com.model.ConfigBlogMark;
import core.com.model.manage.AddBlogReq;
import core.com.model.manage.AddBlogResp;
import core.com.model.manage.BlogLoanInfo;
import core.com.service.manage.ManageBlogService;
import core.com.utils.Constants;
import core.com.utils.ErrorCode;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 后台管理 Blog
 *
 * Created by wangjianan on 16-8-18.
 */
@Service
public class ManageBlogServiceImpl implements ManageBlogService {
    private static final Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private BlogLoanDao blogLoanDao;
    @Autowired
    private ConfigBlogMarkDao configBlogMarkDao;

    @Override
    public AddBlogResp doBlogLoan(AddBlogReq addBlogReq) {
        logger.info("doBlogLoan(): doBlogLoan blog, addBlogReq={}", addBlogReq);
        Assert.notNull(addBlogReq);

        AddBlogResp resp = null;
        String blogChannelGid = addBlogReq.getChannel();
        if (blogChannelGid == null) {
            throw new CoreException(ErrorCode.SYS_PARAMS_ERROR);
        }

        int currentTimeStamp = Utility.getCurrentTimeStamp();
        Integer id = addBlogReq.getId();
        String gid = null;

        BlogLoanWithBLOBs blog = new BlogLoanWithBLOBs();
        blog.setUpdateTime(currentTimeStamp);
        blog.setName(addBlogReq.getName());
        blog.setType(getBlogType(addBlogReq.getType()));
        blog.setChannelGid(blogChannelGid);
        if (addBlogReq.getMessage() != null) {
            blog.setContent(addBlogReq.getMessage());
        }

        if (id != null) {
            blog.setId(addBlogReq.getId());

            BlogLoan blogLoan = blogLoanDao.queryBlogLoanById(id);
            if (blogLoan == null) {
                throw new CoreException(ErrorCode.SYS_PARAMS_ERROR);
            }
            gid = blogLoan.getGid();

            // update
            List<ConfigBlogMark> configBlogMarkList = configBlogMarkDao.queryConfigByBlogGid(gid);
            List<String> updateMarkList = addBlogReq.getMarks();
            if (!CollectionUtils.isEmpty(configBlogMarkList) && !CollectionUtils.isEmpty(updateMarkList)) {
                List<String> markList = configBlogMarkList.stream().map(ConfigBlogMark::getMarkGid).collect(Collectors.toList());

                // init result list
                Set<String> removeSet = new HashSet<>(markList);
                Set<String> addSet = new HashSet<>(updateMarkList);

                // get data
                removeSet.removeAll(addSet);
                addSet.removeAll(markList);

                List<ConfigBlogMark> insertMarkList = getConfigBlogMarkList(new ArrayList<>(addSet), gid);
                logger.info("doBlogLoan(): removeSet={}, addSet={}", removeSet, addSet);

                if (!CollectionUtils.isEmpty(removeSet)) {
                    configBlogMarkDao.deleteByBlog(gid, new ArrayList<>(removeSet));
                }
                doBlogLoan(blog, insertMarkList);
            }
        } else {
            // add
            gid = Utility.generateUUID();
            blog.setCreateTime(currentTimeStamp);
            blog.setGid(gid);
            blog.setUserGid("");
            blog.setMarkGid("");

            List<ConfigBlogMark> insertMarkList = getConfigBlogMarkList(addBlogReq.getMarks(), gid);

            // do operation data
            doBlogLoan(blog, insertMarkList);
        }

        resp = new AddBlogResp();
        resp.setBlogGid(gid);
        logger.info("doBlogLoan(): doBlogLoan save success, resp={}", resp);
        return resp;
    }

    private int getBlogType(String typeName) {
        int type = 0;
        switch (typeName) {
            case Constants.BlogLoanType.TYPE_ORIGINAL:
                type = 0;
                break;
            case Constants.BlogLoanType.TYPE_REPRINT:
                type = 1;
                break;
            case Constants.BlogLoanType.TYPE_TRANSLATE:
                type = 2;
                break;
        }
        return type;
    }

    private List<ConfigBlogMark> getConfigBlogMarkList(List<String> marks, String gid) {
        List<ConfigBlogMark> configBlogMarkList = null;
        int currentTimeStamp = Utility.getCurrentTimeStamp();
        if (marks != null) {
            configBlogMarkList = new ArrayList<>();
            for (String markGid : marks) {
                String configGid = Utility.generateUUID();
                ConfigBlogMark configBlogMark = new ConfigBlogMark();
                configBlogMark.setGid(configGid);
                configBlogMark.setCreateTime(currentTimeStamp);
                configBlogMark.setUpdateTime(currentTimeStamp);
                configBlogMark.setBlogGid(gid);
                configBlogMark.setMarkGid(markGid);
                configBlogMarkList.add(configBlogMark);
            }
        }
        return configBlogMarkList;
    }

    @Override
    public int deleteBlogLoan(String blogLoanGid) {
        logger.info("deleteBlogLoan(): blogLoanGid={}", blogLoanGid);

        int count = blogLoanDao.delete(blogLoanGid);
        logger.info("deleteBlogLoan(): BlogLoan delete success, count={}", count);
        return count;
    }

    @Override
    public BlogLoanInfo getBlogLoan(String blogGid) {
        logger.debug("getBlogLoan(): blogGid={}", blogGid);
        Assert.notNull(blogGid);
        BlogLoanInfo info = new BlogLoanInfo();
        List<ConfigBlogMark> configBlogMarkList = configBlogMarkDao.queryConfigByBlogGid(blogGid);

        info.setBlogLoan(blogLoanDao.selectByGid(blogGid));
        info.setMarkList(configBlogMarkList.stream().map(ConfigBlogMark::getMarkGid).collect(Collectors.toList()));

        logger.debug("getBlogLoan(): response={}", info);
        return info;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    private void doBlogLoan(BlogLoanWithBLOBs blogLoan, List<ConfigBlogMark> configBlogMarkList) {
        logger.info("doBlogLoan(): begin blogLoan={}, configBlogMarkList={}", blogLoan, configBlogMarkList);
        if (blogLoan != null) {
            if (blogLoan.getId() == null) {
                blogLoanDao.insert(blogLoan);
            } else {
                blogLoanDao.updateBlogById(blogLoan);
            }
        }

        if (configBlogMarkList != null && configBlogMarkList.size() > 0) {
            configBlogMarkDao.insertConfigBatch(configBlogMarkList);
        }
        logger.info("doBlogLoan(): end");
    }

}
