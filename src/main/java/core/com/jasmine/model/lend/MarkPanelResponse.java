package core.com.jasmine.model.lend;

/**
 * app
 * Created by wangjianan on 16-8-31.
 */
public class MarkPanelResponse {

    private String name;
    private String markGid;
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarkGid() {
        return markGid;
    }

    public void setMarkGid(String markGid) {
        this.markGid = markGid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MarkPanelResponse{" +
                "name='" + name + '\'' +
                ", markGid='" + markGid + '\'' +
                ", count=" + count +
                '}';
    }
}
