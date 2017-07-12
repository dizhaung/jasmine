package core.com.service.front;

import core.com.model.LightningResponse;
import core.com.model.lend.*;

import java.util.List;

/**
 *
 * Created by wangjianan on 2016/2/17.
 */
public interface BlogService {

    BaseInfoResponse getIndexInfo();

    List<BlogInfo> getBlogInfo(IndexInfoReq indexInfoReq);


    /**
     * 查询详细信息
     *
     * @param indexDetailReq
     * @return
     */
    IndexDetailResp getBlogDetail(IndexDetailReq indexDetailReq);

}
