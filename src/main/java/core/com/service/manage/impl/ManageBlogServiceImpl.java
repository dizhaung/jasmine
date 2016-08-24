package core.com.service.manage.impl;

import core.com.control.manage.BlogController;
import core.com.dao.BlogLoanDao;
import core.com.dao.ConfigBlogMarkDao;
import core.com.exception.CoreException;
import core.com.model.BlogChannel;
import core.com.model.BlogLoan;
import core.com.model.ConfigBlogMark;
import core.com.model.manage.AddBlogReq;
import core.com.model.manage.AddBlogResp;
import core.com.service.manage.ManageBlogService;
import core.com.utils.Constants;
import core.com.utils.ErrorCode;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        AddBlogResp resp = null;
        BlogChannel blogChannel = addBlogReq.getChannel();
        if (blogChannel == null) {
            throw new CoreException(ErrorCode.SYS_PARAMS_ERROR);
        }

        int currentTimeStamp = Utility.getCurrentTimeStamp();
        String blogLoanGid = Utility.generateUUID();
        BlogLoan blog = new BlogLoan();
        blog.setCreateTime(currentTimeStamp);
        blog.setUpdateTime(currentTimeStamp);
        blog.setGid(blogLoanGid);
        blog.setContent(addBlogReq.getMessage());
        blog.setName(addBlogReq.getName());
        blog.setUserGid("");
        blog.setType(getBlogType(addBlogReq.getType()));
        blog.setChannelGid(blogChannel.getGid());
        blog.setMarkGid("");

        List<ConfigBlogMark> configBlogMarkList = null;
        if (addBlogReq.getMarks() != null) {
            configBlogMarkList = new ArrayList<>();
            for (String markGid : addBlogReq.getMarks()) {
                String configGid = Utility.generateUUID();
                ConfigBlogMark configBlogMark = new ConfigBlogMark();
                configBlogMark.setGid(configGid);
                configBlogMark.setCreateTime(currentTimeStamp);
                configBlogMark.setUpdateTime(currentTimeStamp);
                configBlogMark.setBlogGid(blogLoanGid);
                configBlogMark.setMarkGid(markGid);
                configBlogMarkList.add(configBlogMark);
            }
        }

        // do operation data
        doBlogLoan(blog, configBlogMarkList);

        resp = new AddBlogResp();
        resp.setBlogGid(blogLoanGid);
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

    @Override
    public int deleteBlogLoan(String blogLoanGid) {
        logger.info("deleteBlogLoan(): blogLoanGid={}", blogLoanGid);

        int count = blogLoanDao.delete(blogLoanGid);
        logger.info("deleteBlogLoan(): BlogLoan delete success, count={}", count);
        return count;
    }

    @Transactional
    private void doBlogLoan(BlogLoan blogLoan, List<ConfigBlogMark> configBlogMarkList) {
        logger.info("doBlogLoan(): begin blogLoan={}, configBlogMarkList={}", blogLoan, configBlogMarkList);
        if (blogLoan != null) {
            blogLoanDao.insert(blogLoan);
        }

        if (configBlogMarkList != null && configBlogMarkList.size() > 0) {
            configBlogMarkDao.insertConfigBatch(configBlogMarkList);
        }
        logger.info("doBlogLoan(): end");
    }
}
