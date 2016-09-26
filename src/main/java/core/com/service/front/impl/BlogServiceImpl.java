package core.com.service.front.impl;

import core.com.dao.*;
import core.com.model.*;
import core.com.model.lend.BaseInfoResponse;
import core.com.model.lend.IndexInfoReq;
import core.com.model.lend.BlogInfo;
import core.com.service.front.BlogService;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private FriendshipLinkDao friendshipLinkDao;

    @Override
    public BaseInfoResponse getIndexInfo(IndexInfoReq indexInfoReq) {
        logger.info("getIndexInfo(): indexInfoReq={}", indexInfoReq);
        BaseInfoResponse response = new BaseInfoResponse();
        List<BlogInfo> indexInfoRespList = new ArrayList<>();

        List<BlogLoan> blogLoanList = blogLoanDao.queryBlogLoanByMarkOrChannel(indexInfoReq.getChannelGid(), indexInfoReq.getMarkGid());
        if (blogLoanList != null) {
            for (BlogLoan blog : blogLoanList) {

                BlogChannel channel = blogChannelDao.queryChannelByGid(blog.getChannelGid());
                List<ConfigBlogMark> configBlogMarkList = configBlogMarkDao.queryConfigByBlogGid(blog.getGid());
                List<BlogMark> blogMarkList = blogMarkDao.queryMarkByGidList(getMarkList(configBlogMarkList));

                BlogInfo resp = new BlogInfo();
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
        }
        /**
         * 获取最新文章列表
         */
        List<BlogLoan> newBlogLoan = blogLoanDao.queryBlogLoanOrder();

        /** 查询合作链接信息 **/
        List<FriendshipLink> friendshipLinkList = friendshipLinkDao.selectByAll();

        response.setBlogInfoList(indexInfoRespList);
        response.setNewArticleList(newBlogLoan);
        response.setFriendshipLinkList(friendshipLinkList);
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
