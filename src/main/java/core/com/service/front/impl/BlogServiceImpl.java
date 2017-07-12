package core.com.service.front.impl;

import core.com.dao.*;
import core.com.exception.CoreException;
import core.com.model.*;
import core.com.model.lend.*;
import core.com.service.front.BlogService;
import core.com.utils.ErrorCode;
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
    public BaseInfoResponse getIndexInfo() {
        logger.info("getIndexInfo()");
        BaseInfoResponse response = new BaseInfoResponse();
        List<BlogInfo> indexInfoRespList = new ArrayList<>();
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

    @Override
    public List<BlogInfo> getBlogInfo(IndexInfoReq indexInfoReq) {
        logger.info("getBlogInfo(): indexInfoReq={}", indexInfoReq);

        if (indexInfoReq.getChannelGid() != null) {
            String channelName = indexInfoReq.getChannelGid();
            BlogChannel channel = blogChannelDao.queryChannelByName(channelName);
            if (channel != null) {
                indexInfoReq.setChannelGid(channel.getGid());
            }
        }

        if (indexInfoReq.getMarkGid() != null) {
            String markName = indexInfoReq.getMarkGid();
            BlogMark mark = blogMarkDao.queryMarkByGid(markName);
            if (mark != null) {
                indexInfoReq.setMarkGid(mark.getGid());
            }
        }

        List<BlogInfo> resultList = new ArrayList<>();
        List<BlogLoanWithBLOBs> blogLoanList = blogLoanDao.queryBlogLoanByMarkOrChannel(indexInfoReq.getChannelGid(), indexInfoReq.getMarkGid());
        if (blogLoanList != null) {
            for (BlogLoanWithBLOBs blog : blogLoanList) {

                BlogChannel channel = blogChannelDao.queryChannelByGid(blog.getChannelGid());
                List<ConfigBlogMark> configBlogMarkList = configBlogMarkDao.queryConfigByBlogGid(blog.getGid());
                List<BlogMark> blogMarkList = blogMarkDao.queryMarkByGidList(getMarkList(configBlogMarkList));

                BlogInfo resp = new BlogInfo();
                resp.setId(blog.getId());
                resp.setGid(blog.getGid());
                resp.setTime(Utility.getDateTime(blog.getCreateTime()));
                resp.setName(blog.getName());
                resp.setViews(blog.getViews());
                resp.setTop(blog.getIsTop());
                resp.setBlogChannel(channel);
                resp.setBlogMarkList(blogMarkList);
                resp.setContent(blog.getContent());

                resultList.add(resp);
            }
        }
        return resultList;
    }

    @Override
    public IndexDetailResp getBlogDetail(IndexDetailReq indexDetailReq) {
        logger.info("getBlogDetail(): indexDetailReq={}", indexDetailReq);
        IndexDetailResp response = new IndexDetailResp();
        if (null == indexDetailReq || null == indexDetailReq.getBlogId()) {
            logger.info("getBlogDetail(): indexDetailReq or gid is null");
            throw new CoreException(ErrorCode.SYS_PARAMS_ERROR);
        }
        Integer id = indexDetailReq.getBlogId();
        // 更新文章查看次数
        blogLoanDao.updateBlogView(id);
        // 查询blog详细信息
        BlogLoanWithBLOBs blogLoan = blogLoanDao.selectById(id);
        String channelGid = blogLoan.getChannelGid();
        BlogChannel blogChannel = blogChannelDao.queryChannelByGid(channelGid);

        response.setId(blogLoan.getId());
        response.setName(blogLoan.getName());
        response.setGid(blogLoan.getGid());
        response.setContent(blogLoan.getContent());
        response.setViews(blogLoan.getViews());
        response.setChannelGid(channelGid);
        response.setChannelName(blogChannel.getName());
        response.setUserGid(blogLoan.getUserGid());
        response.setDateTime(Utility.getDateFormat(blogLoan.getCreateTime()));

        logger.info("getBlogDetail(): response={}", response);
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
