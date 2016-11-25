package core.com.dao.impl;

import core.com.dao.BlogLoanDao;
import core.com.dao.TestDao;
import core.com.exception.CoreException;
import core.com.model.BlogLoan;
import core.com.utils.ErrorCode;
import core.com.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangjianan on 16-11-24.
 */
@Repository
public class TestDaoImpl implements TestDao {

    @Autowired
    private BlogLoanDao blogLoanDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public void dbId(boolean flag) {
        BlogLoan blog = new BlogLoan();
        int currentTimeStamp = Utility.getCurrentTimeStamp();
        blog.setCreateTime(currentTimeStamp);
        blog.setUpdateTime(currentTimeStamp);
        blog.setGid(Utility.generateUUID());
        blog.setContent("test content");
        blog.setName("test name");
        blog.setUserGid("");
        blog.setType(1);
        blog.setChannelGid("");
        blog.setMarkGid("");
        blogLoanDao.insert(blog);

        if (flag) {
            throw new CoreException(ErrorCode.SYS_PARAMS_ERROR);
        }
    }
}
