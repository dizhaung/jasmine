package core.com.model.lend;

/**
 * app
 * Created by wangjianan on 16-8-31.
 */
public class MarkPanelResponse {

    private String markName;
    private String markGid;
    private int count;

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
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
                "markName='" + markName + '\'' +
                ", markGid='" + markGid + '\'' +
                ", count=" + count +
                '}';
    }
}
