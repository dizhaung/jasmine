package core.com.service.manage;

import core.com.model.BlogLoan;
import core.com.model.manage.AddBlogReq;
import core.com.model.manage.AddBlogResp;
import core.com.model.manage.GetBlogInfo;

/**
 *
 * Created by wangjianan on 16-8-18.
 */
public interface ManageBlogService {

    public AddBlogResp doBlogLoan(AddBlogReq addBlogReq);

    public int deleteBlogLoan(String blogLoan);

    public BlogLoan getBlogLoan(String blogGid);

}
