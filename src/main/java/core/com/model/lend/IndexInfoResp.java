package core.com.model.lend;

/**
 * Created by wangjianan on 16-6-4.
 */
public class IndexInfoResp {

    private String gid;
    private String blogTitle;
    private String blogDateTime;
    private int views;
    private int isTop;
    private String menuName;
    private String userGid;
    private String menuGid;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDateTime() {
        return blogDateTime;
    }

    public void setBlogDateTime(String blogDateTime) {
        this.blogDateTime = blogDateTime;
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

    @Override
    public String toString() {
        return "IndexInfoResp{" +
                "gid='" + gid + '\'' +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogDateTime='" + blogDateTime + '\'' +
                ", views=" + views +
                ", isTop=" + isTop +
                ", menuName='" + menuName + '\'' +
                ", userGid='" + userGid + '\'' +
                ", menuGid='" + menuGid + '\'' +
                '}';
    }
}
