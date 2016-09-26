package core.com.model.lend;

import core.com.model.BlogLoan;
import core.com.model.FriendshipLink;

import java.util.List;

/**
 * Created by wangjianan on 16-9-26.
 */
public class BaseInfoResponse {

    private List<BlogInfo> blogInfoList;
    private List<BlogLoan> newArticleList;
    private List<FriendshipLink> friendshipLinkList;

    public List<BlogInfo> getBlogInfoList() {
        return blogInfoList;
    }

    public void setBlogInfoList(List<BlogInfo> blogInfoList) {
        this.blogInfoList = blogInfoList;
    }

    public List<BlogLoan> getNewArticleList() {
        return newArticleList;
    }

    public void setNewArticleList(List<BlogLoan> newArticleList) {
        this.newArticleList = newArticleList;
    }

    public List<FriendshipLink> getFriendshipLinkList() {
        return friendshipLinkList;
    }

    public void setFriendshipLinkList(List<FriendshipLink> friendshipLinkList) {
        this.friendshipLinkList = friendshipLinkList;
    }

    @Override
    public String toString() {
        return "BaseInfoResponse{" +
                "blogInfoList=" + blogInfoList +
                ", newArticleList=" + newArticleList +
                ", friendshipLinkList=" + friendshipLinkList +
                '}';
    }
}
