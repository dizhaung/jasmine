package core.com.dao.mapper;

import core.com.model.ConfigBlogMark;
import core.com.model.ConfigBlogMarkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfigBlogMarkMapper {
    int countByExample(ConfigBlogMarkExample example);

    int deleteByExample(ConfigBlogMarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConfigBlogMark record);

    int insertSelective(ConfigBlogMark record);

    List<ConfigBlogMark> selectByExample(ConfigBlogMarkExample example);

    ConfigBlogMark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConfigBlogMark record, @Param("example") ConfigBlogMarkExample example);

    int updateByExample(@Param("record") ConfigBlogMark record, @Param("example") ConfigBlogMarkExample example);

    int updateByPrimaryKeySelective(ConfigBlogMark record);

    int updateByPrimaryKey(ConfigBlogMark record);

    int insertConfigBatch(List<ConfigBlogMark> configBlogMarkList);
}