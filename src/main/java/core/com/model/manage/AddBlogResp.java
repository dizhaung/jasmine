package core.com.model.manage;

/**
 * 前端请求 - 添加Blog
 *
 * Created by wangjianan on 16-8-17.
 */
public class AddBlogResp {
    private String blogGid;

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
                '}';
    }
}
