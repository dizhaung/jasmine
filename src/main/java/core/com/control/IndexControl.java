package core.com.control;

import core.com.control.manage.BlogController;
import core.com.model.LightningResponse;
import core.com.model.lend.IndexInfoReq;
import core.com.service.front.BlogService;
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
 * Created by wangjianan on 2016/1/28.
 */
@RestController
@RequestMapping(value = "/index")
public class IndexControl {
    private static final Logger logger = LoggerFactory.getLogger(IndexControl.class);

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/getBills", method = RequestMethod.POST)
    private LightningResponse getBlogData(@RequestBody IndexInfoReq indexInfoReq) {
        logger.info("===> getBlogData(): get bills, indexInfoReq={}", indexInfoReq);
        LightningResponse response = null;
        try {
            response = blogService.getIndexInfo(indexInfoReq);
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("getBlogData(): error, response={}, exception={}", response, e);
        }
        logger.info("<=== getBlogData(): get bills, response={}", response);
        return response;
    }

}
