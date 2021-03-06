package core.com.jasmine.dao.impl;

import core.com.jasmine.dao.BlogLoanDao;
import core.com.jasmine.dao.ConfigBlogMarkDao;
import core.com.jasmine.dao.mapper.BlogLoanMapper;
import core.com.jasmine.model.BlogLoan;
import core.com.jasmine.model.BlogLoanExample;
import core.com.jasmine.model.BlogLoanWithBLOBs;
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

    @Autowired
    private ConfigBlogMarkDao configBlogMarkDao;

    @Override
    public int insert(BlogLoanWithBLOBs blogLoan) {
        return blogLoanMapper.insertSelective(blogLoan);
    }

    @Override
    public List<BlogLoanWithBLOBs> queryBlogLoan(String channelGid) {
        BlogLoanExample example = new BlogLoanExample();
        if (channelGid != null) {
            example.createCriteria().andChannelGidEqualTo(channelGid);
        }
        return blogLoanMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public BlogLoan queryBlogLoanById(Integer id) {
        return blogLoanMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BlogLoan> queryBlogLoanByMarkOrChannelLimit(String channelGid, String markGid, Integer pageIndex, Integer pageSize) {
        return blogLoanMapper.selectByMarkOrChannelLimit(channelGid, markGid, (pageIndex - 1) * pageSize, pageSize);
    }

    @Override
    public int delete(String blogGid) {
        BlogLoanExample example = new BlogLoanExample();
        example.createCriteria().andGidEqualTo(blogGid);
        return blogLoanMapper.deleteByExample(example);
    }

    @Override
    public List<BlogLoan> queryBlogLoanOrder() {
        BlogLoanExample example = new BlogLoanExample();
        example.setOrderByClause("create_time desc limit 4");
        return blogLoanMapper.selectByExample(example);
    }

    @Override
    public BlogLoanWithBLOBs selectByGid(String gid) {
        BlogLoanExample example = new BlogLoanExample();
        example.createCriteria().andGidEqualTo(gid);
        List<BlogLoanWithBLOBs> list = blogLoanMapper.selectByExampleWithBLOBs(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public BlogLoanWithBLOBs selectById(Integer id) {
        BlogLoanExample example = new BlogLoanExample();
        example.createCriteria().andIdEqualTo(id);
        List<BlogLoanWithBLOBs> list = blogLoanMapper.selectByExampleWithBLOBs(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int updateBlogView(Integer blogId) {
        return blogLoanMapper.updateViewById(blogId);
    }

    @Override
    public int updateBlogById(BlogLoanWithBLOBs blogLoan) {
        BlogLoanExample example = new BlogLoanExample();
        example.createCriteria().andIdEqualTo(blogLoan.getId());
        return blogLoanMapper.updateByExampleSelective(blogLoan, example);
    }

    @Override
    public List<BlogLoan> queryBlogLoan() {
        BlogLoanExample example = new BlogLoanExample();
        return blogLoanMapper.selectByExample(example);
    }

    @Override
    public int queryInfoCount(String channelGid, String markGid) {
        BlogLoanExample example = new BlogLoanExample();
        BlogLoanExample.Criteria criteria = example.createCriteria();
        if (channelGid != null) {
            criteria.andChannelGidEqualTo(channelGid);
        }

        if (markGid != null) {
            criteria.andMarkGidEqualTo(markGid);
        }
        return blogLoanMapper.countByExample(example);
    }
}
