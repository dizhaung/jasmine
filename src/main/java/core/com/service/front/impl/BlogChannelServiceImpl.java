package core.com.service.front.impl;

import core.com.dao.BlogChannelDao;
import core.com.exception.CoreException;
import core.com.model.BlogChannel;
import core.com.model.lend.AddChannelReq;
import core.com.model.lend.AddChannelResp;
import core.com.model.lend.BlogChannelMap;
import core.com.service.front.BlogChannelService;
import core.com.utils.Constants;
import core.com.utils.ErrorCode;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service
 * Created by wangjianan on 16-8-30.
 */
@Service
public class BlogChannelServiceImpl implements BlogChannelService {
    private static final Logger logger = LoggerFactory.getLogger(BlogChannelServiceImpl.class);

    @Autowired
    private BlogChannelDao blogChannelDao;

    @Override
    public List<BlogChannel> queryBlogChannel() {
        logger.info("queryBlogChannel(): start");

        List<BlogChannel> blogChannelList = blogChannelDao.queryChannelAll();
        logger.info("queryBlogChannel(): end, response={}", blogChannelList);
        return blogChannelList;
    }

    @Override
    public List<BlogChannelMap> queryBlogChannelGroup() {
        logger.info("queryBlogChannelGroup(): start");

        List<BlogChannelMap> groupList = blogChannelDao.queryChannelGroup();
        logger.info("queryBlogChannelGroup(): end, response={}", groupList);
        return groupList;
    }

    @Override
    public AddChannelResp addBlogChannel(AddChannelReq addChannelReq) {
        if (addChannelReq == null || addChannelReq.isAssert()) {
            throw new CoreException(ErrorCode.SYS_PARAMS_ERROR);
        }
        BlogChannel addChannel = new BlogChannel();
        addChannel.setCreateTime(Utility.getCurrentTimeStamp());
        addChannel.setUpdateTime(Utility.getCurrentTimeStamp());
        addChannel.setDescription(addChannelReq.getChannelDesc());
        addChannel.setName(addChannelReq.getChannelName());
        addChannel.setGid(Utility.generateUUID());
        addChannel.setIsValid(Boolean.TRUE);
        addChannel.setOrderNum(Double.parseDouble(addChannelReq.getChannelOrder()));
        addChannel.setSuperGid(Constants.BlogChannel.ROOT);

        blogChannelDao.insertSelective(addChannel);
        return null;
    }
}
