package core.com.service.front.impl;

import core.com.dao.BlogChannelDao;
import core.com.model.BlogChannel;
import core.com.model.lend.BlogChannelMap;
import core.com.service.front.BlogChannelService;
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
}
