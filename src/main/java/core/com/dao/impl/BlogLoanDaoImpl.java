package core.com.dao.impl;

import core.com.dao.BlogLoanDao;
import core.com.dao.mapper.BlogLoanMapper;
import core.com.model.BlogLoan;
import core.com.model.BlogLoanExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<BlogLoan> queryBlogLoan() {
        BlogLoanExample example = new BlogLoanExample();
        return blogLoanMapper.selectByExample(example);
    }

    @Override
    public int delete(String blogGid) {
        BlogLoanExample example = new BlogLoanExample();
        example.createCriteria().andGidEqualTo(blogGid);
        return blogLoanMapper.deleteByExample(example);
    }
}
