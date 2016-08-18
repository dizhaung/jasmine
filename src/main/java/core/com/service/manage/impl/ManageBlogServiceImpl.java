package core.com.service.manage.impl;

import core.com.control.manage.BlogController;
import core.com.dao.BlogDao;
import core.com.model.manage.AddBlogReq;
import core.com.model.manage.AddBlogResp;
import core.com.service.manage.ManageBlogService;
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
    private BlogDao blogDao;

    @Override
    public AddBlogResp doBlog(AddBlogReq addBlogReq) {
        logger.info("doBlog(): doBlog blog, addBlogReq={}", addBlogReq);
        AddBlogResp resp = null;
//
//        int currentTimeStamp = Utility.getCurrentTimeStamp();
//        String uuid = Utility.generateUUID();
//        Blog blog = new Blog();
//        blog.setCreateTime(currentTimeStamp);
//        blog.setUpdateTime(currentTimeStamp);
//        blog.setGid(uuid);
//        blog.setBlogContent(addBlogReq.getMessage());
//        blog.setBlogTitle(addBlogReq.getName());
//        blog.setMenuGid("");
//        blogDao.insert(blog);
//
//        resp = new AddBlogResp();
//        resp.setBlogGid(uuid);
        logger.info("doBlog(): doBlog save success");
        return resp;
    }
}
