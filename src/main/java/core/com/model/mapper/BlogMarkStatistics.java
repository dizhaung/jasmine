package core.com.model.mapper;

/**
 * Created by wangjianan on 16-8-31.
 */
public class BlogMarkStatistics implements Comparable<BlogMarkStatistics> {
    private String gid;
    private String name;
    private Integer count;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BlogMarkStatistics{" +
                "gid='" + gid + '\'' +
                ", name='" + name + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    @Override
    public int compareTo(BlogMarkStatistics o) {
        if (this.count != null && o.getCount() != null && this.count > o.getCount()) {
            return 1;
        } else {
            return 0;
        }
    }
}
