package core.com.service.manage.impl;

import core.com.model.LightningResponse;
import core.com.model.manage.ManageIndexReq;
import core.com.service.manage.ManageIndexService;
import org.springframework.stereotype.Service;

/**
 * Created by wangjianan on 16-7-10.
 */
@Service
public class ManageIndexServiceImpl implements ManageIndexService {



    @Override
    public LightningResponse queryBlogByType(ManageIndexReq manageIndexReq) {
        LightningResponse response = new LightningResponse();

        return response;
    }
}
