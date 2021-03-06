package core.com.jasmine.control;

import core.com.jasmine.model.LightningResponse;
import core.com.jasmine.model.lend.IndexDetailReq;
import core.com.jasmine.model.lend.IndexInfoReq;
import core.com.jasmine.service.BlogService;
import core.com.jasmine.utils.ErrorCode;
import core.com.jasmine.utils.Utility;
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

    @RequestMapping(value = "/getIndexInfo", method = RequestMethod.POST)
    private LightningResponse getIndexInfo() {
        logger.info("===> getBlogData(): get bills");
        LightningResponse response = null;
        try {
            response = Utility.getSuccessResp(blogService.getIndexInfo());
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("getBlogData(): error, response={}, exception={}", response, e);
        }

        logger.info("<=== getBlogData(): get bills, response={}", response);
        return response;
    }

    @RequestMapping(value = "/getBlogInfo", method = RequestMethod.POST)
    private LightningResponse getBlogInfo(@RequestBody IndexInfoReq indexInfoReq) {
        logger.info("===> getBaseInfo(): get bills, indexInfoReq={}", indexInfoReq);
        LightningResponse response = null;
        try {
            response = Utility.getSuccessResp(blogService.queryInfoByLimit(indexInfoReq));
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("getBaseInfo(): error, response={}, exception={}", response, e);
        }

        logger.info("<=== getBaseInfo(): get bills, response={}", response);
        return response;
    }

    @RequestMapping(value = "/getBillDetail", method = RequestMethod.POST)
    private LightningResponse getBlogDetail(@RequestBody IndexDetailReq indexDetailReq) {
        logger.info("===> getBlogDetail(): get bills detail, indexDetailReq={}", indexDetailReq);
        LightningResponse response = null;
        try {
            response = Utility.getSuccessResp(blogService.getBlogDetail(indexDetailReq));
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("getBlogDetail(): error, response={}, exception={}", response, e);
        }
        logger.info("<=== getBlogDetail(): get bill detail, response={}", response);
        return response;
    }

}
