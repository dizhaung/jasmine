package core.com.dao.impl;

import core.com.dao.BlogLoanDao;
import core.com.dao.mapper.BlogLoanMapper;
import core.com.model.BlogLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Blog dao
 * Created by wangjianan on 16-8-18.
 */
@Repository
public class BlogLoanDaoImpl implements BlogLoanDao {

    @Autowired
    private BlogLoanMapper blogLoanMapper;

    @Override
    public int insert(BlogLoan blogLoan) {
        return blogLoanMapper.insertSelective(blogLoan);
    }
}
