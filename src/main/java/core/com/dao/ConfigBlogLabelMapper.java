package core.com.dao;

import core.com.model.ConfigBlogLabel;
import core.com.model.ConfigBlogLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfigBlogLabelMapper {
    int countByExample(ConfigBlogLabelExample example);

    int deleteByExample(ConfigBlogLabelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConfigBlogLabel record);

    int insertSelective(ConfigBlogLabel record);

    List<ConfigBlogLabel> selectByExample(ConfigBlogLabelExample example);

    ConfigBlogLabel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConfigBlogLabel record, @Param("example") ConfigBlogLabelExample example);

    int updateByExample(@Param("record") ConfigBlogLabel record, @Param("example") ConfigBlogLabelExample example);

    int updateByPrimaryKeySelective(ConfigBlogLabel record);

    int updateByPrimaryKey(ConfigBlogLabel record);
}