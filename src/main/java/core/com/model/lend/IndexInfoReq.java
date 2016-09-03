package core.com.model.lend;

/**
 * Created by wangjianan on 16-6-4.
 */
public class IndexInfoReq {

    private String channelGid;
    private String markGid;

    public String getChannelGid() {
        return channelGid;
    }

    public void setChannelGid(String channelGid) {
        this.channelGid = channelGid;
    }

    public String getMarkGid() {
        return markGid;
    }

    public void setMarkGid(String markGid) {
        this.markGid = markGid;
    }

    @Override
    public String toString() {
        return "IndexInfoReq{" +
                "channelGid='" + channelGid + '\'' +
                ", markGid='" + markGid + '\'' +
                '}';
    }
}
