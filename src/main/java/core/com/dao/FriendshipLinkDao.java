package core.com.dao;

import core.com.model.FriendshipLink;

import java.util.List;

/**
 * Created by wangjianan on 16-9-26.
 */
public interface FriendshipLinkDao {

    public List<FriendshipLink> selectByAll();

    public int insertSelective(FriendshipLink friendshipLink);
}
