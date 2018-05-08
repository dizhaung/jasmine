package core.com.jasmine.model.manage;

/**
 * 前端请求 - 添加Blog
 *
 * Created by wangjianan on 16-8-17.
 */
public class AddBlogResp {
    private String blogGid;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogGid() {
        return blogGid;
    }

    public void setBlogGid(String blogGid) {
        this.blogGid = blogGid;
    }

    @Override
    public String toString() {
        return "AddBlogResp{" +
                "blogGid='" + blogGid + '\'' +
                ", id=" + id +
                '}';
    }
}
