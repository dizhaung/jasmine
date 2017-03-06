package core.com.dao.impl;

import core.com.dao.BlogLoanDao;
import core.com.dao.ConfigBlogMarkDao;
import core.com.dao.mapper.BlogLoanMapper;
import core.com.model.BlogLoan;
import core.com.model.BlogLoanExample;
import core.com.model.BlogLoanWithBLOBs;
import core.com.model.ConfigBlogMark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.stream.Collectors;

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
    public List<BlogLoanWithBLOBs> queryBlogLoanByMarkOrChannel(String channelGid, String markGid) {
        BlogLoanExample example = new BlogLoanExample();
        List<String> blogList = new ArrayList<>();
        if (markGid != null) {
            List<ConfigBlogMark> list = configBlogMarkDao.queryConfigByMarkGid(markGid);
            blogList.addAll(list.stream().map(ConfigBlogMark::getBlogGid).collect(Collectors.toList()));
            if (list.size() <= 0) {
                return null;
            }
        }
        if (blogList.size() > 0) {
            example.createCriteria().andGidIn(blogList);
        }

        if (channelGid != null) {
            example.createCriteria().andChannelGidEqualTo(channelGid);
        }
        return blogLoanMapper.selectByExampleWithBLOBs(example);
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
    public int updateBlogView(String blogGid) {
        return blogLoanMapper.updateViewByGid(blogGid);
    }

    @Override
    public int updateBlogById(BlogLoanWithBLOBs blogLoan) {
        BlogLoanExample example = new BlogLoanExample();
        example.createCriteria().andIdEqualTo(blogLoan.getId());
        return blogLoanMapper.updateByExampleSelective(blogLoan, example);
    }
}
