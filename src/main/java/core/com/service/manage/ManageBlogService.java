package core.com.service.manage;

import core.com.model.manage.AddBlogReq;
import core.com.model.manage.AddBlogResp;

/**
 *
 * Created by wangjianan on 16-8-18.
 */
public interface ManageBlogService {

    public AddBlogResp doBlogLoan(AddBlogReq addBlogReq);
}
