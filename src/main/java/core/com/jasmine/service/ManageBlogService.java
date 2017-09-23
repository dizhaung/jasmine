package core.com.jasmine.service;

import core.com.jasmine.model.manage.AddBlogReq;
import core.com.jasmine.model.manage.AddBlogResp;
import core.com.jasmine.model.manage.BlogLoanInfo;

/**
 *
 * Created by wangjianan on 16-8-18.
 */
public interface ManageBlogService {

    AddBlogResp doBlogLoan(AddBlogReq addBlogReq);

    int deleteBlogLoan(String blogLoan);

    BlogLoanInfo getBlogLoan(String blogGid);

}
