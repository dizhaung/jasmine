package core.com.jasmine.service;

import core.com.jasmine.model.BlogLoanWithBLOBs;
import core.com.jasmine.model.manage.ManageIndexReq;

import java.util.List;

/**
 * Created by wangjianan on 16-7-10.
 */
public interface ManageIndexService {

    List<BlogLoanWithBLOBs> queryBlogByType(ManageIndexReq manageIndexReq);
}
