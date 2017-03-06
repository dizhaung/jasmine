package core.com.service.manage;

import core.com.model.BlogLoan;
import core.com.model.BlogLoanWithBLOBs;
import core.com.model.LightningResponse;
import core.com.model.manage.ManageIndexReq;

import java.util.List;

/**
 * Created by wangjianan on 16-7-10.
 */
public interface ManageIndexService {

    List<BlogLoanWithBLOBs> queryBlogByType(ManageIndexReq manageIndexReq);
}
