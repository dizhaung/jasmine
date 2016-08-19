package core.com.dao.impl;

import core.com.dao.BlogChannelDao;
import core.com.dao.mapper.BlogChannelMapper;
import core.com.model.BlogChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
