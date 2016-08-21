package core.com.service.front.impl;

import core.com.control.manage.ChannelController;
import core.com.dao.BlogLoanDao;
import core.com.model.BlogLoan;
import core.com.model.LightningResponse;
import core.com.model.lend.IndexInfoReq;
import core.com.model.lend.IndexInfoResp;
import core.com.service.front.BlogService;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianan on 2016/2/17.
 */
@Service
public class BlogServiceImpl implements BlogService {
    private static final Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);

    @Autowired
    private BlogLoanDao blogLoanDao;

    @Override
    public LightningResponse getIndexInfo(IndexInfoReq indexInfoReq) {
        logger.info("getIndexInfo(): indexInfoReq={}", indexInfoReq);
        LightningResponse response = new LightningResponse();
        List<IndexInfoResp> indexInfoRespList = new ArrayList<>();

        List<BlogLoan> blogLoanList = blogLoanDao.queryBlogLoan();
        for (BlogLoan blog : blogLoanList) {
            IndexInfoResp resp = new IndexInfoResp();
            resp.setGid(blog.getGid());
            resp.setBlogCreateTime(Utility.getDateTime(blog.getCreateTime()));
            resp.setBlogName(blog.getName());
            resp.setViews(blog.getViews());
            resp.setUserGid(blog.getUserGid());
            resp.setTop(blog.getIsTop());
            indexInfoRespList.add(resp);
        }
        response.setContent(indexInfoRespList);

        logger.info("getIndexInfo(): response={}", response);
        return response;
    }
}
