package core.com.service.front;

import core.com.model.LightningResponse;
import core.com.model.lend.BaseInfoResponse;
import core.com.model.lend.IndexDetailReq;
import core.com.model.lend.IndexDetailResp;
import core.com.model.lend.IndexInfoReq;

/**
 *
 * Created by wangjianan on 2016/2/17.
 */
public interface BlogService {

    BaseInfoResponse getIndexInfo(IndexInfoReq indexInfoReq);

    /**
     * 查询详细信息
     *
     * @param indexDetailReq
     * @return
     */
    IndexDetailResp getBlogDetail(IndexDetailReq indexDetailReq);
}
