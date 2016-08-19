package core.com.model.manage;

/**
 * Created by wangjianan on 16-8-19.
 */
public class AddChannelResponse {

    private String channelName;
    private String channelGid;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelGid() {
        return channelGid;
    }

    public void setChannelGid(String channelGid) {
        this.channelGid = channelGid;
    }

    @Override
    public String toString() {
        return "AddChannelResponse{" +
                "channelName='" + channelName + '\'' +
                ", channelGid='" + channelGid + '\'' +
                '}';
    }
}
