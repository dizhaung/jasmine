package core.com.jasmine.model.manage;

/**
 *
 * Created by wangjianan on 16-8-19.
 */
public class AddChannelRequest {

    private String channelName;
    private String channelDesc;
    private String channelId;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelDesc() {
        return channelDesc;
    }

    public void setChannelDesc(String channelDesc) {
        this.channelDesc = channelDesc;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "AddChannelRequest{" +
                "channelName='" + channelName + '\'' +
                ", channelDesc='" + channelDesc + '\'' +
                ", channelId='" + channelId + '\'' +
                '}';
    }
}
