package core.com.dao.mapper;

import core.com.model.FriendshipLink;
import core.com.model.FriendshipLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendshipLinkMapper {
    int countByExample(FriendshipLinkExample example);

    int deleteByExample(FriendshipLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FriendshipLink record);

    int insertSelective(FriendshipLink record);

    List<FriendshipLink> selectByExample(FriendshipLinkExample example);

    FriendshipLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FriendshipLink record, @Param("example") FriendshipLinkExample example);

    int updateByExample(@Param("record") FriendshipLink record, @Param("example") FriendshipLinkExample example);

    int updateByPrimaryKeySelective(FriendshipLink record);

    int updateByPrimaryKey(FriendshipLink record);
}