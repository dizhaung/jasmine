package core.com.service.front;

import core.com.model.LightningResponse;
import core.com.model.lend.IndexInfoReq;

/**
 *
 * Created by wangjianan on 2016/2/17.
 */
public interface BlogService {
    LightningResponse getIndexInfo(IndexInfoReq indexInfoReq);
}
