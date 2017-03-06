package core.com.model;

public class BlogLoan {
    private Integer id;

    private String gid;

    private Integer createTime;

    private Integer updateTime;

    private String userGid;

    private String channelGid;

    private String markGid;

    private String name;

    private Integer type;

    private Integer views;

    private Boolean isTop;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserGid() {
        return userGid;
    }

    public void setUserGid(String userGid) {
        this.userGid = userGid == null ? null : userGid.trim();
    }

    public String getChannelGid() {
        return channelGid;
    }

    public void setChannelGid(String channelGid) {
        this.channelGid = channelGid == null ? null : channelGid.trim();
    }

    public String getMarkGid() {
        return markGid;
    }

    public void setMarkGid(String markGid) {
        this.markGid = markGid == null ? null : markGid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Boolean getIsTop() {
        return isTop;
    }

    public void setIsTop(Boolean isTop) {
        this.isTop = isTop;
    }

    @Override
    public String toString() {
        return "BlogLoan{" +
                "id=" + id +
                ", gid='" + gid + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userGid='" + userGid + '\'' +
                ", channelGid='" + channelGid + '\'' +
                ", markGid='" + markGid + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", views=" + views +
                ", isTop=" + isTop +
                '}';
    }
}