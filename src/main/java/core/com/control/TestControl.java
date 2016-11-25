package core.com.control;

import core.com.model.LightningResponse;
import core.com.service.manage.TestService;
import core.com.utils.ErrorCode;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangjianan on 16-11-24.
 */
@RestController
@RequestMapping(value = "/test")
public class TestControl {
    private static final Logger logger = LoggerFactory.getLogger(TestControl.class);

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/dbId", method = RequestMethod.GET)
    private LightningResponse code(@RequestParam boolean flag) {
        logger.info("===> code(): get bills");
        LightningResponse response = null;
        try {
            testService.dbId(flag);
            response = Utility.getSuccessResp(1);
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("code(): error, response={}, exception={}", response, e);
        }

        logger.info("<=== code(): get bills, response={}", response);
        return response;
    }
}
