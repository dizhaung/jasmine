package core.com.service.impl;

import core.com.dao.BlogMapper;
import core.com.model.Blog;
import core.com.model.BlogExample;
import core.com.model.LightningResponse;
import core.com.model.lend.IndexInfoReq;
import core.com.model.lend.IndexInfoResp;
import core.com.model.mapper.BlogInfoModel;
import core.com.service.BlogService;
import core.com.utils.Constants;
import core.com.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by wangjianan on 2016/2/17.
 */
@Service
public class BolgServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public LightningResponse getIndexInfo(IndexInfoReq indexInfoReq) {
        LightningResponse response = new LightningResponse();
        List<IndexInfoResp> indexInfoRespList = new ArrayList<>();

        List<BlogInfoModel> infoModelList = blogMapper.queryBlogByMenuType(indexInfoReq.getMenuGid());
        for (BlogInfoModel blog : infoModelList) {
            IndexInfoResp resp = new IndexInfoResp();
            resp.setGid(blog.getGid());
            resp.setBlogDateTime(Utility.getDateTime(blog.getCreateTime()));
            resp.setBlogTitle(blog.getBlogTitle());
            resp.setMenuGid(blog.getMenuGid());
            resp.setMenuName(blog.getMenuName());
            resp.setViews(blog.getViews());
            resp.setUserGid(blog.getUserGid());
            resp.setIsTop(blog.getIsTop());
            indexInfoRespList.add(resp);
        }
        response.setContent(indexInfoRespList);
        return response;
    }

    @Override
    public LightningResponse blogAdd(Blog blog) {
        LightningResponse response = null;
        blog.setUpdateTime(Utility.getCurrentTimeStamp());
        blog.setCreateTime(Utility.getCurrentTimeStamp());
        blog.setGid(UUID.randomUUID().toString());
        blog.setViews(0);
        try {
            blogMapper.insertSelective(blog);
        } catch (Exception e) {
            response = new LightningResponse();
            response.setStatus(-1);
            response.setMessage("插入失败");
        }
        return response;
    }


}
