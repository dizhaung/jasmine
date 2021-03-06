package core.com.jasmine.dao;

import core.com.jasmine.model.BlogMark;
import core.com.jasmine.model.mapper.BlogMarkStatistics;

import java.util.List;

/**
 * mark dao
 *
 * Created by wangjianan on 16-8-23.
 */
public interface BlogMarkDao {
    int insert(BlogMark blogMark);

    List<BlogMark> queryMarkAll();

    BlogMark queryMarkByGid(String markGid);

    BlogMark queryMarkByName(String name);

    List<BlogMark> queryMarkByGidList(List<String> markGidList);

    List<BlogMarkStatistics> getBlogMarkStatistics();
}
