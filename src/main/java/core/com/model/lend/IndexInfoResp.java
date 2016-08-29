package core.com.model.lend;

import core.com.model.BlogChannel;
import core.com.model.BlogMark;
import core.com.model.UserBase;

import java.util.List;

/**
 * Created by wangjianan on 16-6-4.
 */
public class IndexInfoResp {

    private String gid;
    private String name;
    private String time;
    private String type;
    private String content;
    private int views;
    private boolean isTop;
    private UserBase userBase;
    private BlogChannel blogChannel;
    private List<BlogMark> blogMarkList;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    public UserBase getUserBase() {
        return userBase;
    }

    public void setUserBase(UserBase userBase) {
        this.userBase = userBase;
    }

    public BlogChannel getBlogChannel() {
        return blogChannel;
    }

    public void setBlogChannel(BlogChannel blogChannel) {
        this.blogChannel = blogChannel;
    }

    public List<BlogMark> getBlogMarkList() {
        return blogMarkList;
    }

    public void setBlogMarkList(List<BlogMark> blogMarkList) {
        this.blogMarkList = blogMarkList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "IndexInfoResp{" +
                "gid='" + gid + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", type='" + type + '\'' +
                ", views=" + views +
                ", isTop=" + isTop +
                ", userBase=" + userBase +
                ", blogChannel=" + blogChannel +
                ", blogMarkList=" + blogMarkList +
                '}';
    }
}
