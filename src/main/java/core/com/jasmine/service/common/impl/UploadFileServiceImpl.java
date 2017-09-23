package core.com.jasmine.service.common.impl;

import com.qiniu.storage.model.DefaultPutRet;
import core.com.jasmine.service.common.UploadFileService;
import core.com.jasmine.service.common.VendorHttpClientService;
import core.com.jasmine.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by wangjianan on 16-11-27.
 */
@Service
public class UploadFileServiceImpl implements UploadFileService {
    private static final Logger logger = LoggerFactory.getLogger(UploadFileServiceImpl.class);

    @Autowired
    private VendorHttpClientService vendorHttpClientService;

    @Override
    public String put(MultipartFile attach) {
        logger.debug("put() begin;");
        DefaultPutRet ret = null;
        int currentTimeStamp = Utility.getCurrentTimeStamp();
        try {
            String fileName = attach.getOriginalFilename();
            String extName = fileName.substring(fileName.lastIndexOf("."))
                    .toLowerCase();
            ret = vendorHttpClientService.uploadQinNiu(attach.getBytes(), currentTimeStamp + extName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.debug("put() end: filename={}", ret.key);
        return ret.key;
    }
}
