package core.com.control;

import core.com.service.common.UploadFileService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by wangjianan on 16-11-27.
 */
@RestController
@RequestMapping(value = "/upload")
public class UploadFileController {
    private static final Logger logger = LoggerFactory.getLogger(UploadFileController.class);

    @Autowired
    private UploadFileService uploadFileService;

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    private void put(HttpServletRequest request, HttpServletResponse response,
                     @RequestParam(value = "editormd-image-file", required = false) MultipartFile attach,
                     @RequestParam String dialog_id) {
        logger.info("===> put(): dialog_id={}", dialog_id);

        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            request.setCharacterEncoding("utf-8");
            String rootPath = request.getSession().getServletContext().getRealPath("/upload/");

            /**
             * 文件路径不存在则需要创建文件路径
             */
            File filePath = new File(rootPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }

            String fileName = uploadFileService.put(attach);

            //最终文件名
            File realFile = new File(rootPath + File.separator + attach.getOriginalFilename());
            FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);
            String callback = request.getParameter("callback");
            //下面response返回的json格式是editor.md所限制的，规范输出就OK
            String url = callback + "?success=1&message=success&url=http://og4nfuylr.bkt.clouddn.com/" + fileName + "&dialog_id=" + dialog_id;
            response.sendRedirect(url);
        } catch (Exception e) {
            try {
                response.getWriter().write("{\"success\":0}");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        logger.info("<=== put(): response={}", response);
    }
}
