package core.com.jasmine.control.manage;

import core.com.jasmine.exception.CoreException;
import core.com.jasmine.model.LightningResponse;
import core.com.jasmine.model.manage.AddBlogReq;
import core.com.jasmine.service.ManageBlogService;
import core.com.jasmine.utils.ErrorCode;
import core.com.jasmine.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * manage
 *
 * Created by wangjianan on 16-8-17.
 */
@RestController
@RequestMapping(value = "/manage/blog")
public class BlogController {
    private static final Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private ManageBlogService manageBlogService;

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    private LightningResponse doBlog(@RequestBody AddBlogReq addBlogReq) {
        logger.info("===> manage doBlog(): addBlogReq={}", addBlogReq);
        LightningResponse response = null;

        if (addBlogReq == null || Utility.isBlank(addBlogReq.getName()) || Utility.isBlank(addBlogReq.getMessage())) {
            response = Utility.getErrorResponse(ErrorCode.SYS_PARAMETER_ERROR);
            return response;
        }

        try {
            response = Utility.getSuccessResp(manageBlogService.doBlogLoan(addBlogReq));
        } catch (CoreException c) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("doBlog(): add or update is error, exception={}", c);
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("doBlog(): add or update is error, exception={}", e);
        }
        logger.info("<=== manage doBlog(): response={}", response);
        return response;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    private LightningResponse delete(@RequestBody String blogGid) {
        logger.info("===> manage delete(): blogGid={}", blogGid);
        LightningResponse response = null;

        if (blogGid == null) {
            response = Utility.getErrorResponse(ErrorCode.SYS_PARAMETER_ERROR);
            return response;
        }

        try {
            response = Utility.getSuccessResp(manageBlogService.deleteBlogLoan(blogGid));
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("add(): delete is error, exception={}", e);
        }
        logger.info("<=== manage delete(): response={}", response);
        return response;
    }

    @RequestMapping(value = "/getBlog", method = RequestMethod.POST)
    private LightningResponse getBlogInfo(@RequestBody String blogGid) {
        logger.info("===> manage getBlogInfo(): blogGid={}", blogGid);
        LightningResponse response = null;

        if (blogGid == null) {
            response = Utility.getErrorResponse(ErrorCode.SYS_PARAMETER_ERROR);
            return response;
        }

        try {
            response = Utility.getSuccessResp(manageBlogService.getBlogLoan(blogGid));
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("getBlogInfo(): query is error, exception={}", e);
        }
        logger.info("<=== manage getBlogInfo(): response={}", response);
        return response;
    }
}