package core.com.jasmine.dao.impl;

import core.com.jasmine.dao.FriendshipLinkDao;
import core.com.jasmine.dao.mapper.FriendshipLinkMapper;
import core.com.jasmine.model.FriendshipLink;
import core.com.jasmine.model.FriendshipLinkExample;
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

    @Override
    public int insertSelective(FriendshipLink friendshipLink) {
        return friendshipLinkMapper.insertSelective(friendshipLink);
    }
}
