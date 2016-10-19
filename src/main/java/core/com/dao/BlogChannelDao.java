package core.com.dao;

import core.com.model.BlogChannel;
import core.com.model.lend.BlogChannelMap;

import java.util.List;

/**
 * channel dao
 *
 * Created by wangjianan on 16-8-19.
 */
public interface BlogChannelDao {

    int insert(BlogChannel blogChannel);

    List<BlogChannel> queryChannelAll();

    BlogChannel queryChannelByGid(String blogGid);

    List<BlogChannelMap> queryChannelGroup();
}
