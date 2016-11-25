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

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    private void upload(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "editormd-image-file", required = false) MultipartFile attach,
                        @RequestParam String dialog_id) {
        logger.info("===> manage upload(): dialog_id={}", dialog_id);

        try {
            request.setCharacterEncoding("utf-8");
            String rootPath = request.getSession().getServletContext().getRealPath("/upload/");

            /**
             * 文件路径不存在则需要创建文件路径
             */
            File filePath = new File(rootPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }

            //最终文件名
            File realFile = new File(rootPath + File.separator + attach.getOriginalFilename());
            FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);

            // response
            UploadResponse uploadResponse = new UploadResponse();
            uploadResponse.setSuccess(1);
            uploadResponse.setMessage("上传成功");
            uploadResponse.setUrl("http://og4nfuylr.bkt.clouddn.com/1745332,106.jpg");
            uploadResponse.setDialog_id(dialog_id);
            //下面response返回的json格式是editor.md所限制的，规范输出就OK
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.getWriter().write(new Gson().toJson(uploadResponse));
        } catch (Exception e) {
            try {
                response.getWriter().write("{\"success\":0}");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        logger.info("<=== manage upload(): response={}", response);
    }
}