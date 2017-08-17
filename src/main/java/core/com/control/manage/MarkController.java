package core.com.control.manage;

import core.com.model.LightningResponse;
import core.com.model.manage.AddMarkRequest;
import core.com.service.ManageMarkService;
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
 * Created by wangjianan on 16-8-23.
 */
@RestController
@RequestMapping(value = "/manage/mark")
public class MarkController {
    private static final Logger logger = LoggerFactory.getLogger(MarkController.class);

    @Autowired
    private ManageMarkService manageMarkService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private LightningResponse mark(@RequestBody AddMarkRequest addMarkRequest) {
        logger.info("===> mark mark(): addMarkRequest={}", addMarkRequest);
        LightningResponse response = null;

        if (addMarkRequest == null || Utility.isBlank(addMarkRequest.getName())) {
            response = Utility.getErrorResponse(ErrorCode.SYS_PARAMETER_ERROR);
            return response;
        }

        try {
            response = Utility.getSuccessResp(manageMarkService.doMark(addMarkRequest));
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("channel(): channel is error, exception={}", e);
        }
        logger.info("<=== mark mark(): response={}", response);
        return response;
    }

    @RequestMapping(value = "/getMark", method = RequestMethod.POST)
    private LightningResponse queryMark() {
        logger.info("===> mark queryMark():");
        LightningResponse response = null;

        try {
            response = Utility.getSuccessResp(manageMarkService.queryMark());
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("queryMark(): mark is error, exception={}", e);
        }
        logger.info("<=== mark queryMark(): response={}", response);
        return response;
    }

}
