package core.com.jasmine.model.common;

import java.util.List;

/**
 * Created by wangjianan on 17-7-18.
 */
public class BaiduUrlResponse {

    private int success;
    private int remain;
    private List<String> not_same_site;
    private List<String> not_valid;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public List<String> getNot_same_site() {
        return not_same_site;
    }

    public void setNot_same_site(List<String> not_same_site) {
        this.not_same_site = not_same_site;
    }

    public List<String> getNot_valid() {
        return not_valid;
    }

    public void setNot_valid(List<String> not_valid) {
        this.not_valid = not_valid;
    }

    @Override
    public String toString() {
        return "BaiduUrlResponse{" +
                "success=" + success +
                ", remain=" + remain +
                ", not_same_site=" + not_same_site +
                ", not_valid=" + not_valid +
                '}';
    }
}
