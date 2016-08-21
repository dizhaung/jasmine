package core.com.service.manage.impl;

import core.com.control.manage.ChannelController;
import core.com.dao.BlogChannelDao;
import core.com.model.BlogChannel;
import core.com.model.manage.AddChannelRequest;
import core.com.model.manage.AddChannelResponse;
import core.com.service.manage.ManageChannelService;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjianan on 16-8-19.
 */
@Service
public class ManageChannelServiceImpl implements ManageChannelService {
    private static final Logger logger = LoggerFactory.getLogger(ManageChannelServiceImpl.class);

    @Autowired
    private BlogChannelDao blogChannelDao;

    @Override
    public BlogChannel doChannel(AddChannelRequest addChannelRequest) {
        logger.info("doChannel(): addChannelRequest={}", addChannelRequest);

        String blogChannelGid = Utility.generateUUID();
        int currentTimeStamp = Utility.getCurrentTimeStamp();
        BlogChannel blogChannel = new BlogChannel();
        blogChannel.setGid(blogChannelGid);
        blogChannel.setName(addChannelRequest.getChannelName());
        blogChannel.setCreateTime(currentTimeStamp);
        blogChannel.setUpdateTime(currentTimeStamp);
        blogChannel.setDescription(addChannelRequest.getChannelDesc());
        blogChannel.setSuperGid("");
        blogChannel.setIsValid(Boolean.TRUE);
        blogChannel.setOrderNum(0.0);

        blogChannelDao.insert(blogChannel);
        logger.info("doChannel(): response={}", blogChannel);
        return blogChannel;
    }

    @Override
    public List<BlogChannel> queryChannel() {
        return blogChannelDao.queryChannelAll();
    }
}
