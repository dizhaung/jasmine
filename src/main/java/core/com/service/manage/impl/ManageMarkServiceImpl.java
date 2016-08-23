package core.com.service.manage.impl;

import core.com.dao.BlogChannelDao;
import core.com.dao.BlogMarkDao;
import core.com.model.BlogMark;
import core.com.model.manage.AddMarkRequest;
import core.com.service.manage.ManageMarkService;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * mark service
 *
 * Created by wangjianan on 16-8-23.
 */
@Service
public class ManageMarkServiceImpl implements ManageMarkService {
    private static final Logger logger = LoggerFactory.getLogger(ManageMarkServiceImpl.class);

    @Autowired
    private BlogMarkDao blogMarkDao;

    @Override
    public BlogMark doMark(AddMarkRequest addMarkRequest) {
        logger.info("doMark(): addMarkRequest={}", addMarkRequest);

        int currentTimeStamp = Utility.getCurrentTimeStamp();
        String markGid = Utility.generateUUID();
        BlogMark blogMark = new BlogMark();
        blogMark.setCreateTime(currentTimeStamp);
        blogMark.setUpdateTime(currentTimeStamp);
        blogMark.setName(addMarkRequest.getName());
        blogMark.setDecription(addMarkRequest.getDescription());
        blogMark.setGid(markGid);
        blogMarkDao.insert(blogMark);
        logger.info("doMark(): response={}", blogMark);
        return blogMark;
    }

    @Override
    public List<BlogMark> queryMark() {
        return blogMarkDao.queryMarkAll();
    }
}
