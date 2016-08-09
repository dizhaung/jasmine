package core.com.model;

public class ConfigBlogLabel {
    private Integer id;

    private String gid;

    private String blogGid;

    private String labelGid;

    private Integer createTime;

    private Integer updateTime;

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

    public String getBlogGid() {
        return blogGid;
    }

    public void setBlogGid(String blogGid) {
        this.blogGid = blogGid == null ? null : blogGid.trim();
    }

    public String getLabelGid() {
        return labelGid;
    }

    public void setLabelGid(String labelGid) {
        this.labelGid = labelGid == null ? null : labelGid.trim();
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
}