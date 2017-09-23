package core.com.jasmine.service.common;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by wangjianan on 16-11-27.
 */
public interface UploadFileService {

    public String put(MultipartFile attach);
}
