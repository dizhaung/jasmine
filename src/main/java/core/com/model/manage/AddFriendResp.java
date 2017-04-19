package core.com.model.manage;

/**
 * 前端请求 - 添加Blog
 *
 * Created by wangjianan on 16-8-17.
 */
public class AddFriendResp {
    private String friendGid;

    public String getFriendGid() {
        return friendGid;
    }

    public void setFriendGid(String friendGid) {
        this.friendGid = friendGid;
    }

    @Override
    public String toString() {
        return "AddFriendResp{" +
                "friendGid='" + friendGid + '\'' +
                '}';
    }
}
