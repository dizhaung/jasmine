package core.com.jasmine.model.manage;

/**
 * Created by wangjianan on 16-7-10.
 */
public class ManageIndexReq {

    private String channelGid;

    public String getChannelGid() {
        return channelGid;
    }

    public void setChannelGid(String channelGid) {
        this.channelGid = channelGid;
    }

    @Override
    public String toString() {
        return "ManageIndexReq{" +
                "channelGid='" + channelGid + '\'' +
                '}';
    }
}
