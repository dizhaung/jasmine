package core.com.service.manage;

import core.com.model.LightningResponse;
import core.com.model.manage.ManageIndexReq;

/**
 * Created by wangjianan on 16-7-10.
 */
public interface ManageIndexService {

    LightningResponse queryBlogByType(ManageIndexReq manageIndexReq);
}
