package core.com.service.front.impl;

import core.com.control.manage.ChannelController;
import core.com.dao.BlogChannelDao;
import core.com.dao.BlogLoanDao;
import core.com.dao.BlogMarkDao;
import core.com.dao.ConfigBlogMarkDao;
import core.com.model.*;
import core.com.model.lend.IndexInfoReq;
import core.com.model.lend.IndexInfoResp;
import core.com.service.front.BlogService;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianan on 2016/2/17.
 */
@Service
public class BlogServiceImpl implements BlogService {
    private static final Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);

    @Autowired
    private BlogLoanDao blogLoanDao;
    @Autowired
    private BlogChannelDao blogChannelDao;
    @Autowired
    private BlogMarkDao blogMarkDao;
    @Autowired
    private ConfigBlogMarkDao configBlogMarkDao;

    @Override
    public LightningResponse getIndexInfo(IndexInfoReq indexInfoReq) {
        logger.info("getIndexInfo(): indexInfoReq={}", indexInfoReq);
        LightningResponse response = new LightningResponse();
        List<IndexInfoResp> indexInfoRespList = new ArrayList<>();

        List<BlogLoan> blogLoanList = blogLoanDao.queryBlogLoan();
        for (BlogLoan blog : blogLoanList) {

            BlogChannel channel = blogChannelDao.queryChannelByGid(blog.getChannelGid());
            List<ConfigBlogMark> configBlogMarkList = configBlogMarkDao.queryConfigByBlogGid(blog.getGid());
            List<BlogMark> blogMarkList = blogMarkDao.queryMarkByGidList(getMarkList(configBlogMarkList));

            IndexInfoResp resp = new IndexInfoResp();
            resp.setGid(blog.getGid());
            resp.setTime(Utility.getDateTime(blog.getCreateTime()));
            resp.setName(blog.getName());
            resp.setViews(blog.getViews());
            resp.setTop(blog.getIsTop());
            resp.setBlogChannel(channel);
            resp.setBlogMarkList(blogMarkList);
            resp.setContent(blog.getContent());

            indexInfoRespList.add(resp);
        }
        response.setContent(indexInfoRespList);

        logger.info("getIndexInfo(): response={}", response);
        return response;
    }

    private List<String> getMarkList(List<ConfigBlogMark> configBlogMarkList) {
        List<String> result = null;
        if (configBlogMarkList != null && configBlogMarkList.size() > 0) {
            result = new ArrayList<>();
            for (ConfigBlogMark config : configBlogMarkList) {
                result.add(config.getMarkGid());
            }
        }
        return result;
    }
}
