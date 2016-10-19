package core.com.model.lend;

/**
 * Created by wangjianan on 16-10-19.
 */
public class BlogChannelMap {
    private String name;
    private Integer count;

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
        return "BlogChannelMap{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
