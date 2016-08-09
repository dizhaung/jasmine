package core.com.service.manage.impl;

import core.com.dao.BlogMapper;
import core.com.exception.CoreException;
import core.com.model.Blog;
import core.com.model.BlogExample;
import core.com.model.LightningResponse;
import core.com.model.lend.IndexInfoResp;
import core.com.model.manage.ManageIndexReq;
import core.com.service.manage.ManageIndexService;
import core.com.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjianan on 16-7-10.
 */
@Service
public class ManageIndexServiceImpl implements ManageIndexService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public LightningResponse queryBlogByType(ManageIndexReq manageIndexReq) {
        LightningResponse response = new LightningResponse();
        if (manageIndexReq == null) {
            throw new CoreException(ErrorCode.SYS_PARAMS_ERROR);
        }
        BlogExample example = new BlogExample();
//        example.createCriteria().andMenuGidEqualTo(manageIndexReq.getMenuGid());
        List<Blog> blogs = blogMapper.selectByExample(example);
        response.setContent(blogs);
        return response;
    }
}
