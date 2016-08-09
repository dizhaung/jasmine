package core.com.model.mapper;

/**
 * Created by wangjianan on 16-6-4.
 */
public class BlogInfoModel {
    private String gid;
    private String userGid;
    private String menuGid;
    private String blogTitle;
    private int views;
    private int isTop;
    private String menuName;
    private int createTime;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getUserGid() {
        return userGid;
    }

    public void setUserGid(String userGid) {
        this.userGid = userGid;
    }

    public String getMenuGid() {
        return menuGid;
    }

    public void setMenuGid(String menuGid) {
        this.menuGid = menuGid;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BlogInfoModel{" +
                "gid='" + gid + '\'' +
                ", userGid='" + userGid + '\'' +
                ", menuGid='" + menuGid + '\'' +
                ", blogTitle='" + blogTitle + '\'' +
                ", views=" + views +
                ", isTop=" + isTop +
                ", menuName='" + menuName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
