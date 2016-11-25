package core.com.service.common;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import core.com.exception.CoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by wangjianan on 16-11-27.
 */
@Service
public class VendorHttpClientService {
    private final static Logger logger = LoggerFactory.getLogger(VendorHttpClientService.class);

    @Value("${vendor.upload.ak}")
    private String ACCESS_KEY;
    @Value("${vendor.upload.sk}")
    private String SECRET_KEY;
    @Value("${vendor.upload.bucket}")
    private String bucket;

    public DefaultPutRet uploadQinNiu(byte[] data, String fileName) {
        UploadManager uploadManager = new UploadManager();
        DefaultPutRet ret = null;
        try {
            Response res = uploadManager.put(data, fileName, getToken(bucket, null));
            ret = res.jsonToObject(DefaultPutRet.class);
        } catch (QiniuException e) {
            logger.error("uploadQinNiu(): put QiNiu error, Exception={}", e);
            Response r = e.response;
            // 请求失败时简单状态信息
        }
        return ret;
    }


    private String getToken(String bucket, String key) {
        if (bucket == null || bucket.length() < 1) {
            logger.warn("invalid json string to generate SK");
            throw new CoreException("4500");
        }
        String token = null;
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        token = auth.uploadToken(bucket, key);

        logger.debug("auth-token: {}", token);
        return token;
    }

}
