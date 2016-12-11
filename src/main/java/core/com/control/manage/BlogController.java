package core.com.control.manage;

import com.google.gson.Gson;
import core.com.exception.CoreException;
import core.com.model.LightningResponse;
import core.com.model.manage.AddBlogReq;
import core.com.model.manage.ManageIndexReq;
import core.com.model.manage.UploadResponse;
import core.com.service.manage.ManageBlogService;
import core.com.utils.ErrorCode;
import core.com.utils.Utility;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by wangjianan on 16-8-17.
 */
@RestController
@RequestMapping(value = "/manage/blog")
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
        } catch (CoreException c) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("add(): add is error, exception={}", c);
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("add(): add is error, exception={}", e);
        }
        logger.info("<=== manage add(): response={}", response);
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
    private LightningResponse getBlog(@RequestBody String blogGid) {
        logger.info("===> manage getBlog(): blogGid={}", blogGid);
        LightningResponse response = null;

        if (blogGid == null) {
            response = Utility.getErrorResponse(ErrorCode.SYS_PARAMETER_ERROR);
            return response;
        }

        try {
            response = Utility.getSuccessResp(manageBlogService.getBlogInfo(blogGid));
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("getBlog(): getBlog is error, exception={}", e);
        }
        logger.info("<=== manage getBlog(): response={}", response);
        return response;
    }
}