package core.com.dao.impl;

import core.com.dao.BlogChannelDao;
import core.com.dao.mapper.BlogChannelMapper;
import core.com.model.BlogChannel;
import core.com.model.BlogChannelExample;
import core.com.model.lend.BlogChannelMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * blog dao
 *
 * Created by wangjianan on 16-8-19.
 */
@Repository
public class BlogChannelDaoImpl implements BlogChannelDao {

    @Autowired
    private BlogChannelMapper blogChannelMapper;

    @Override
    public int insertSelective(BlogChannel blogChannel) {
        return blogChannelMapper.insertSelective(blogChannel);
    }

    @Override
    public List<BlogChannel> queryChannelAll() {
        BlogChannelExample example = new BlogChannelExample();
        return blogChannelMapper.selectByExample(example);
    }

    @Override
    public BlogChannel queryChannelByGid(String gid) {
        BlogChannelExample example = new BlogChannelExample();
        example.createCriteria().andGidEqualTo(gid);
        List<BlogChannel> blogChannelList = blogChannelMapper.selectByExample(example);
        if (blogChannelList != null && blogChannelList.size() > 0) {
            return blogChannelList.get(0);
        }
        return null;
    }

    @Override
    public BlogChannel queryChannelByName(String channelName) {
        BlogChannelExample example = new BlogChannelExample();
        example.createCriteria().andNameEqualTo(channelName);
        List<BlogChannel> blogChannelList = blogChannelMapper.selectByExample(example);
        if (blogChannelList != null && blogChannelList.size() > 0) {
            return blogChannelList.get(0);
        }
        return null;
    }

    @Override
    public List<BlogChannelMap> queryChannelGroup() {
        return blogChannelMapper.selectByGroupChannel();
    }

    @Override
    public int deleteByGid(String channelGid) {
        BlogChannelExample example = new BlogChannelExample();
        example.createCriteria().andGidEqualTo(channelGid);
        return blogChannelMapper.deleteByExample(example);
    }
}
