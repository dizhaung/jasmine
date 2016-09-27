package core.com.model.lend;

/**
 * Created by wangjianan on 16-9-27.
 */
public class IndexDetailReq {
    private String blogGid;

    public String getBlogGid() {
        return blogGid;
    }

    public void setBlogGid(String blogGid) {
        this.blogGid = blogGid;
    }

    @Override
    public String toString() {
        return "IndexDetailReq{" +
                "blogGid='" + blogGid + '\'' +
                '}';
    }
}
