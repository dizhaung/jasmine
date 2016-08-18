package core.com.service.front.impl;

import core.com.model.LightningResponse;
import core.com.model.lend.IndexInfoReq;
import core.com.model.lend.IndexInfoResp;
import core.com.service.front.BlogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by wangjianan on 2016/2/17.
 */
@Service
public class BolgServiceImpl implements BlogService {

    @Override
    public LightningResponse getIndexInfo(IndexInfoReq indexInfoReq) {
        LightningResponse response = new LightningResponse();
        List<IndexInfoResp> indexInfoRespList = new ArrayList<>();

//        List<BlogInfoModel> infoModelList = blogMapper.queryBlogByMenuType(indexInfoReq.getMenuGid());
//        for (BlogInfoModel blog : infoModelList) {
//            IndexInfoResp resp = new IndexInfoResp();
//            resp.setGid(blog.getGid());
//            resp.setBlogDateTime(Utility.getDateTime(blog.getCreateTime()));
//            resp.setBlogTitle(blog.getBlogTitle());
//            resp.setMenuGid(blog.getMenuGid());
//            resp.setMenuName(blog.getMenuName());
//            resp.setViews(blog.getViews());
//            resp.setUserGid(blog.getUserGid());
//            resp.setIsTop(blog.getIsTop());
//            indexInfoRespList.add(resp);
//        }
//        response.setContent(indexInfoRespList);
        return response;
    }
}
