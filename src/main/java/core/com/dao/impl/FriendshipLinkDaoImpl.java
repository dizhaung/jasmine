package core.com.dao.impl;

import core.com.dao.FriendshipLinkDao;
import core.com.dao.mapper.FriendshipLinkMapper;
import core.com.model.FriendshipLink;
import core.com.model.FriendshipLinkExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangjianan on 16-9-26.
 */
@Repository
public class FriendshipLinkDaoImpl implements FriendshipLinkDao {

    @Autowired
    private FriendshipLinkMapper friendshipLinkMapper;

    @Override
    public List<FriendshipLink> selectByAll() {
        FriendshipLinkExample example = new FriendshipLinkExample();
        example.createCriteria().andIsVaildEqualTo(true);
        return friendshipLinkMapper.selectByExample(example);
    }
}
