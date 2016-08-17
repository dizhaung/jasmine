package core.com.control.manage;

import core.com.model.LightningResponse;
import core.com.model.manage.AddBlogReq;
import core.com.model.manage.ManageIndexReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by wangjianan on 16-8-17.
 */
@RestController
@RequestMapping(value = "/manage")
public class BlogController {
    private static final Logger logger = LoggerFactory.getLogger(BlogController.class);

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private LightningResponse add(@RequestBody AddBlogReq addBlogReq) {
        logger.info("===> manage add(): addBlogReq={}", addBlogReq);
        LightningResponse response = null;


        logger.info("<=== manage add(): response={}", response);
        return response;
    }

}
