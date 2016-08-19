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

/**
 * Created by wangjianan on 16-8-19.
 */
@Service
public class ManageChannelServiceImpl implements ManageChannelService {
    private static final Logger logger = LoggerFactory.getLogger(ManageChannelServiceImpl.class);

    @Autowired
    private BlogChannelDao blogChannelDao;

    @Override
    public AddChannelResponse doChannel(AddChannelRequest addChannelRequest) {
        logger.info("doChannel(): addChannelRequest={}", addChannelRequest);
        AddChannelResponse response = null;

        String blogChannelGid = Utility.generateUUID();
        int currentTimeStamp = Utility.getCurrentTimeStamp();
        BlogChannel blogChannel = new BlogChannel();
        blogChannel.setGid(blogChannelGid);
        blogChannel.setName(addChannelRequest.getChannelName());
        blogChannel.setCreateTime(currentTimeStamp);
        blogChannel.setUpdateTime(currentTimeStamp);
        blogChannel.setDescription(addChannelRequest.getChannelDesc());
        blogChannel.setSuperGid("");

        blogChannelDao.insert(blogChannel);
        response = new AddChannelResponse();
        response.setChannelName(blogChannel.getName());
        response.setChannelGid(blogChannelGid);
        logger.info("doChannel(): response={}", response);
        return response;
    }
}
