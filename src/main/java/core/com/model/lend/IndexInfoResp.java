package core.com.model.lend;

/**
 * Created by wangjianan on 16-6-4.
 */
public class IndexInfoResp {

    private String gid;
    private String blogName;
    private String blogCreateTime;
    private String userGid;
    private int views;
    private boolean isTop;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogCreateTime() {
        return blogCreateTime;
    }

    public void setBlogCreateTime(String blogCreateTime) {
        this.blogCreateTime = blogCreateTime;
    }

    public String getUserGid() {
        return userGid;
    }

    public void setUserGid(String userGid) {
        this.userGid = userGid;
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

    @Override
    public String toString() {
        return "IndexInfoResp{" +
                "gid='" + gid + '\'' +
                ", blogName='" + blogName + '\'' +
                ", blogCreateTime='" + blogCreateTime + '\'' +
                ", userGid='" + userGid + '\'' +
                ", views=" + views +
                ", isTop=" + isTop +
                '}';
    }
}
