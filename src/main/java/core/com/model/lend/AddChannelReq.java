package core.com.model.lend;

/**
 *
 * Created by wangjianan on 16-6-4.
 */
public class AddChannelReq {

    private String channelName;
    private String channelDesc;
    private String channelOrder;

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

    public String getChannelOrder() {
        return channelOrder;
    }

    public void setChannelOrder(String channelOrder) {
        this.channelOrder = channelOrder;
    }

    public boolean isAssert() {
        return this.channelName == null || this.channelDesc == null || this.channelOrder == null;
    }

    @Override
    public String toString() {
        return "AddChannelReq{" +
                "channelName='" + channelName + '\'' +
                ", channelDesc='" + channelDesc + '\'' +
                ", channelOrder='" + channelOrder + '\'' +
                '}';
    }
}
