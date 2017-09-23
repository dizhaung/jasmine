package core.com.jasmine.service.impl;

import core.com.jasmine.dao.FriendshipLinkDao;
import core.com.jasmine.model.FriendshipLink;
import core.com.jasmine.model.manage.AddFriendReq;
import core.com.jasmine.model.manage.AddFriendResp;
import core.com.jasmine.service.FriendService;
import core.com.jasmine.utils.Utility;
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

    @Override
    public AddFriendResp add(AddFriendReq addFriendReq) {

        FriendshipLink link = new FriendshipLink();
        link.setUserGid(null);
        link.setCreateTime(Utility.getCurrentTimeStamp());
        link.setUpdateTime(Utility.getCurrentTimeStamp());
        link.setDescription(addFriendReq.getFriendDesc());
        link.setUrl(addFriendReq.getFriendLink());
        link.setGid(Utility.generateUUID());
        link.setName(addFriendReq.getFriendName());
        link.setIsVaild(Boolean.TRUE);
        friendshipLinkDao.insertSelective(link);

        AddFriendResp resp = new AddFriendResp();
        resp.setFriendGid(link.getGid());
        return resp;
    }
}
