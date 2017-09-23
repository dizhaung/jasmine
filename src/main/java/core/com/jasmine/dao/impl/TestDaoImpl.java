package core.com.jasmine.dao.impl;

import core.com.jasmine.dao.BlogLoanDao;
import core.com.jasmine.dao.TestDao;
import core.com.jasmine.exception.CoreException;
import core.com.jasmine.model.BlogLoanWithBLOBs;
import core.com.jasmine.utils.ErrorCode;
import core.com.jasmine.utils.Utility;
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
        BlogLoanWithBLOBs blog = new BlogLoanWithBLOBs();
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
