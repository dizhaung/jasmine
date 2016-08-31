package core.com.dao.impl;

import core.com.dao.BlogMarkDao;
import core.com.dao.mapper.BlogMarkMapper;
import core.com.model.BlogMark;
import core.com.model.BlogMarkExample;
import core.com.model.mapper.BlogMarkStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mark dao impl
 *
 * Created by wangjianan on 16-8-23.
 */
@Repository
public class BlogMarkDaoImpl implements BlogMarkDao {

    @Autowired
    private BlogMarkMapper blogMarkMapper;

    @Override
    public int insert(BlogMark blogMark) {
        return blogMarkMapper.insertSelective(blogMark);
    }

    @Override
    public List<BlogMark> queryMarkAll() {
        BlogMarkExample example = new BlogMarkExample();
        return blogMarkMapper.selectByExample(example);
    }

    @Override
    public BlogMark queryMarkByGid(String markGid) {
        BlogMarkExample example = new BlogMarkExample();
        example.createCriteria().andGidEqualTo(markGid);
        List<BlogMark> blogMarkList = blogMarkMapper.selectByExample(example);
        if (blogMarkList != null && blogMarkList.size() > 0) {
            return blogMarkList.get(0);
        }
        return null;
    }

    @Override
    public List<BlogMark> queryMarkByGidList(List<String> markGidList) {
        if (markGidList == null) {
            return null;
        }
        BlogMarkExample example = new BlogMarkExample();
        example.createCriteria().andGidIn(markGidList);
        return blogMarkMapper.selectByExample(example);
    }

    @Override
    public List<BlogMarkStatistics> getBlogMarkStatistics() {
        return blogMarkMapper.getBlogMarkStatistics();
    }

}
