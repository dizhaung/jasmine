package core.com.jasmine.service.impl;

import core.com.jasmine.dao.BlogChannelDao;
import core.com.jasmine.model.BlogChannel;
import core.com.jasmine.model.manage.AddChannelRequest;
import core.com.jasmine.service.ManageChannelService;
import core.com.jasmine.utils.Utility;
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
        blogChannel.setSuperGid(addChannelRequest.getChannelId());
        blogChannel.setIsValid(Boolean.TRUE);
        blogChannel.setOrderNum(0.0);

        blogChannelDao.insertSelective(blogChannel);
        logger.info("doChannel(): response={}", blogChannel);
        return blogChannel;
    }

    @Override
    public List<BlogChannel> queryChannel() {
        List<BlogChannel> blogChannelList = blogChannelDao.queryChannelAll();
        // 增加基本博客类型，根root
        BlogChannel root = new BlogChannel();
        root.setGid("root");
        root.setName("Root");
        blogChannelList.add(root);

        return blogChannelList;
    }
}
