package core.com.service;

import core.com.model.FriendshipLink;
import core.com.model.manage.AddFriendReq;
import core.com.model.manage.AddFriendResp;

import java.util.List;

/**
 * friend service
 * <p>
 * Created by wangjianan on 17-4-19.
 */
public interface FriendService {

    public List<FriendshipLink> getFriendInfo();

    public AddFriendResp add(AddFriendReq addFriendReq);
}
