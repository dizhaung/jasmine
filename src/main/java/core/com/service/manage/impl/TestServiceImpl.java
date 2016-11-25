package core.com.service.manage.impl;

import core.com.control.TestControl;
import core.com.dao.BlogLoanDao;
import core.com.dao.TestDao;
import core.com.exception.CoreException;
import core.com.model.BlogLoan;
import core.com.service.manage.TestService;
import core.com.utils.ErrorCode;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
