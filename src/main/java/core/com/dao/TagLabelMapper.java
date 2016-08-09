package core.com.dao;

import core.com.model.TagLabel;
import core.com.model.TagLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagLabelMapper {
    int countByExample(TagLabelExample example);

    int deleteByExample(TagLabelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TagLabel record);

    int insertSelective(TagLabel record);

    List<TagLabel> selectByExample(TagLabelExample example);

    TagLabel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TagLabel record, @Param("example") TagLabelExample example);

    int updateByExample(@Param("record") TagLabel record, @Param("example") TagLabelExample example);

    int updateByPrimaryKeySelective(TagLabel record);

    int updateByPrimaryKey(TagLabel record);
}