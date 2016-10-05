package core.com.model.lend;

import core.com.model.BlogLoan;
import core.com.model.UserBase;

/**
 * Created by wangjianan on 16-9-27.
 */
public class IndexDetailResp {

    private String gid;
    private String name;
    private String dateTime;
    private Integer views;
    private String channelGid;
    private String channelName;
    private String content;
    private String userGid;
    private String userName;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getChannelGid() {
        return channelGid;
    }

    public void setChannelGid(String channelGid) {
        this.channelGid = channelGid;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserGid() {
        return userGid;
    }

    public void setUserGid(String userGid) {
        this.userGid = userGid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "IndexDetailResp{" +
                "gid='" + gid + '\'' +
                ", name='" + name + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", views='" + views + '\'' +
                ", channelGid='" + channelGid + '\'' +
                ", channelName='" + channelName + '\'' +
                ", userGid='" + userGid + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
