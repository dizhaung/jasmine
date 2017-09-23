package core.com.jasmine.service;

import core.com.jasmine.model.FriendshipLink;
import core.com.jasmine.model.manage.AddFriendReq;
import core.com.jasmine.model.manage.AddFriendResp;

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
