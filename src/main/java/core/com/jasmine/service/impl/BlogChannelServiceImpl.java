package core.com.jasmine.service.impl;

import core.com.jasmine.dao.BlogChannelDao;
import core.com.jasmine.exception.CoreException;
import core.com.jasmine.model.BlogChannel;
import core.com.jasmine.model.lend.AddChannelReq;
import core.com.jasmine.model.lend.AddChannelResp;
import core.com.jasmine.model.lend.BlogChannelMap;
import core.com.jasmine.service.BlogChannelService;
import core.com.jasmine.utils.Constants;
import core.com.jasmine.utils.ErrorCode;
import core.com.jasmine.utils.Utility;
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

    @Override
    public int delete(String channelGid) {
        if (Utility.isBlank(channelGid)) {
            throw new CoreException(ErrorCode.SYS_PARAMS_ERROR);
        }

        return blogChannelDao.deleteByGid(channelGid);
    }
}
