package core.com.dao;

import core.com.model.BlogChannel;
import core.com.model.BlogMark;

import java.util.List;

/**
 * mark dao
 *
 * Created by wangjianan on 16-8-23.
 */
public interface BlogMarkDao {
    int insert(BlogMark blogMark);

    List<BlogMark> queryMarkAll();
}