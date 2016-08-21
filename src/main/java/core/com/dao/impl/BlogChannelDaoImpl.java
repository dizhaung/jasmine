package core.com.dao.impl;

import core.com.dao.BlogChannelDao;
import core.com.dao.mapper.BlogChannelMapper;
import core.com.model.BlogChannel;
import core.com.model.BlogChannelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangjianan on 16-8-19.
 */
@Repository
public class BlogChannelDaoImpl implements BlogChannelDao {

    @Autowired
    private BlogChannelMapper blogChannelMapper;

    @Override
    public int insert(BlogChannel blogChannel) {
        return blogChannelMapper.insert(blogChannel);
    }

    @Override
    public List<BlogChannel> queryChannelAll() {
        BlogChannelExample example = new BlogChannelExample();
        return blogChannelMapper.selectByExample(example);
    }
}
