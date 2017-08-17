package core.com.service.impl;

import core.com.dao.TestDao;
import core.com.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangjianan on 16-11-24.
 */
@Service
public class TestServiceImpl implements TestService {
    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    private TestDao testDao;

    @Override
    public void dbId(boolean flag) {
        logger.debug("dbId() begin: flag={}", flag);
        testDao.dbId(flag);
        logger.debug("dbId() end: flag={}", flag);
    }

}
