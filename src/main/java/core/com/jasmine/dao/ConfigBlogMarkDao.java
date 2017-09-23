package core.com.jasmine.dao;

import core.com.jasmine.model.ConfigBlogMark;

import java.util.List;

/**
 * Created by wangjianan on 16-8-23.
 */
public interface ConfigBlogMarkDao {

    int insertConfigBatch(List<ConfigBlogMark> configBlogMarkList);

    List<ConfigBlogMark> queryConfigByBlogGid(String blogGid);

    List<ConfigBlogMark> queryConfigByMarkGid(String markGid);

    int deleteByBlog(String blogGid, List<String> markList);
}
