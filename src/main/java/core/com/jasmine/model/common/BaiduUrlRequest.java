package core.com.jasmine.model.common;

import java.util.List;

/**
 * Created by wangjianan on 17-7-18.
 */
public class BaiduUrlRequest {

    private List<String> urls;

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "BaiduUrlRequest{" +
                "urls=" + urls +
                '}';
    }
}
