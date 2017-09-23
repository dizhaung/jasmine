package core.com.jasmine.model.lend;

/**
 * Created by wangjianan on 16-6-4.
 */
public class IndexInfoReq {

    private String channelGid;
    private String markGid;
    private Integer pageIndex;
    private Integer pageSize;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

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
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                '}';
    }
}
