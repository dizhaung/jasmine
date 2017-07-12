package core.com.model.lend;

/**
 * Created by wangjianan on 16-9-27.
 */
public class IndexDetailReq {
    private Integer blogId;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    @Override
    public String toString() {
        return "IndexDetailReq{" +
                "blogId=" + blogId +
                '}';
    }
}
