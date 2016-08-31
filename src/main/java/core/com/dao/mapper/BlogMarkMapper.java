package core.com.dao.mapper;

import core.com.model.BlogMark;
import core.com.model.BlogMarkExample;
import java.util.List;

import core.com.model.mapper.BlogMarkStatistics;
import org.apache.ibatis.annotations.Param;

public interface BlogMarkMapper {
    int countByExample(BlogMarkExample example);

    int deleteByExample(BlogMarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogMark record);

    int insertSelective(BlogMark record);

    List<BlogMark> selectByExample(BlogMarkExample example);

    BlogMark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogMark record, @Param("example") BlogMarkExample example);

    int updateByExample(@Param("record") BlogMark record, @Param("example") BlogMarkExample example);

    int updateByPrimaryKeySelective(BlogMark record);

    int updateByPrimaryKey(BlogMark record);

    List<BlogMarkStatistics> getBlogMarkStatistics();
}