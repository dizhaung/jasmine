package core.com.service.front.impl;

import core.com.dao.FriendshipLinkDao;
import core.com.model.FriendshipLink;
import core.com.service.front.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * friend impl
 *
 * Created by wangjianan on 17-4-19.
 */
@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendshipLinkDao friendshipLinkDao;

    @Override
    public List<FriendshipLink> getFriendInfo() {
        return friendshipLinkDao.selectByAll();
    }
}
