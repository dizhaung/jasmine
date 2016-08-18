package core.com.control.manage;

import core.com.model.LightningResponse;
import core.com.model.manage.AddBlogReq;
import core.com.model.manage.ManageIndexReq;
import core.com.service.manage.ManageBlogService;
import core.com.utils.ErrorCode;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ManageBlogService manageBlogService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private LightningResponse add(@RequestBody AddBlogReq addBlogReq) {
        logger.info("===> manage add(): addBlogReq={}", addBlogReq);
        LightningResponse response = null;

        if (addBlogReq == null || Utility.isBlank(addBlogReq.getName()) || Utility.isBlank(addBlogReq.getMessage())) {
            response = Utility.getErrorResponse(ErrorCode.SYS_PARAMETER_ERROR);
            return response;
        }

        try {
            response = Utility.getSuccessResp(manageBlogService.doBlogLoan(addBlogReq));
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("add(): add is error, exception={}", e);
        }
        logger.info("<=== manage add(): response={}", response);
        return response;
    }

}