package core.com.dao;

import core.com.model.ConfigBlogMark;

import java.util.List;

/**
 * Created by wangjianan on 16-8-23.
 */
public interface ConfigBlogMarkDao {

    int insertConfigBatch(List<ConfigBlogMark> configBlogMarkList);

    List<ConfigBlogMark> queryConfigByBlogGid(String blogGid);

    List<ConfigBlogMark> queryConfigByMarkGid(String markGid);
}
