package core.com.jasmine.model.manage;

/**
 * 前端请求 - 添加 修改 Blog
 *
 * Created by wangjianan on 16-8-17.
 */
public class AddFriendReq {
    private String friendName;
    private String friendLink;
    private String friendDesc;

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFriendLink() {
        return friendLink;
    }

    public void setFriendLink(String friendLink) {
        this.friendLink = friendLink;
    }

    public String getFriendDesc() {
        return friendDesc;
    }

    public void setFriendDesc(String friendDesc) {
        this.friendDesc = friendDesc;
    }

    @Override
    public String toString() {
        return "AddFriendReq{" +
                "friendName='" + friendName + '\'' +
                ", friendLink='" + friendLink + '\'' +
                ", friendDesc='" + friendDesc + '\'' +
                '}';
    }
}
