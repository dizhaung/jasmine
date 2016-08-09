package core.com.control;

import core.com.model.Blog;
import core.com.model.LightningResponse;
import core.com.model.lend.IndexInfoReq;
import core.com.service.BlogService;
import core.com.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangjianan on 2016/1/28.
 */
@RestController
public class IndexControl {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/static/getBlogData", method = RequestMethod.POST)
    private LightningResponse getBlogData(@RequestBody IndexInfoReq indexInfoReq) {
        LightningResponse response = null;
        try {
            response = blogService.getIndexInfo(indexInfoReq);
        } catch (Exception e) {
            response = Utility.getErrorResponse();
            response.setMessage("系统异常，请稍候重试！");
            e.printStackTrace();
        }
        return response;
    }

    @RequestMapping(value = "/static/blogAdd", method = RequestMethod.POST)
    private LightningResponse blogAdd(@RequestBody Blog blog) {
        LightningResponse response = null;
        response = blogService.blogAdd(blog);
        return response;
    }

}
