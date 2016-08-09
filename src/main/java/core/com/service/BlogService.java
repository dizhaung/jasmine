package core.com.service;

import core.com.model.Blog;
import core.com.model.LightningResponse;
import core.com.model.lend.IndexInfoReq;

/**
 * Created by wangjianan on 2016/2/17.
 */
public interface BlogService {

    public LightningResponse getIndexInfo(IndexInfoReq indexInfoReq);

    public LightningResponse blogAdd(Blog blog);
}
