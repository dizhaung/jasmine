package core.com.service.manage.impl;

import core.com.control.manage.BlogController;
import core.com.dao.BlogLoanDao;
import core.com.model.BlogLoan;
import core.com.model.manage.AddBlogReq;
import core.com.model.manage.AddBlogResp;
import core.com.service.manage.ManageBlogService;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 后台管理 Blog
 *
 * Created by wangjianan on 16-8-18.
 */
@Service
public class ManageBlogServiceImpl implements ManageBlogService {
    private static final Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private BlogLoanDao blogLoanDao;

    @Override
    public AddBlogResp doBlogLoan(AddBlogReq addBlogReq) {
        logger.info("doBlogLoan(): doBlogLoan blog, addBlogReq={}", addBlogReq);
        AddBlogResp resp = null;

        int currentTimeStamp = Utility.getCurrentTimeStamp();
        String uuid = Utility.generateUUID();
        BlogLoan blog = new BlogLoan();
        blog.setCreateTime(currentTimeStamp);
        blog.setUpdateTime(currentTimeStamp);
        blog.setGid(uuid);
        blog.setContent(addBlogReq.getMessage());
        blog.setName(addBlogReq.getName());
        blog.setUserGid("");
        blog.setChannelGid("");
        blog.setMarkGid("");
        blogLoanDao.insert(blog);

        resp = new AddBlogResp();
        resp.setBlogGid(uuid);
        logger.info("doBlogLoan(): doBlogLoan save success, resp={}", resp);
        return resp;
    }
}
