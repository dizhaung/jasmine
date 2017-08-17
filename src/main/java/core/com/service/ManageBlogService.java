package core.com.service;

import core.com.model.BlogLoan;
import core.com.model.manage.AddBlogReq;
import core.com.model.manage.AddBlogResp;
import core.com.model.manage.BlogLoanInfo;
import core.com.model.manage.GetBlogInfo;

/**
 *
 * Created by wangjianan on 16-8-18.
 */
public interface ManageBlogService {

    AddBlogResp doBlogLoan(AddBlogReq addBlogReq);

    int deleteBlogLoan(String blogLoan);

    BlogLoanInfo getBlogLoan(String blogGid);

}
