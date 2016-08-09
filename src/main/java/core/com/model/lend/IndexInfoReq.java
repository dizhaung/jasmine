package core.com.model.lend;

/**
 * Created by wangjianan on 16-6-4.
 */
public class IndexInfoReq {

    private String menuGid;

    public String getMenuGid() {
        return menuGid;
    }

    public void setMenuGid(String menuGid) {
        this.menuGid = menuGid;
    }

    @Override
    public String toString() {
        return "IndexInfoReq{" +
                "menuGid=" + menuGid +
                '}';
    }
}
