package core.com.control;

import core.com.model.LightningResponse;
import core.com.service.BlogMarkService;
import core.com.utils.ErrorCode;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * app
 * Created by wangjianan on 16-8-31.
 */
@RestController
@RequestMapping(value = "/mark")
public class BlogMarkController {
    private static final Logger logger = LoggerFactory.getLogger(BlogMarkController.class);

    @Autowired
    private BlogMarkService blogMarkService;

    @RequestMapping(value = "/getMark", method = RequestMethod.POST)
    private LightningResponse getMark() {
        logger.info("===> getMark(): get mark");
        LightningResponse response = null;
        try {
            response = Utility.getSuccessResp(blogMarkService.getBlogMarkStatistics());
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("getMark(): error, response={}, exception={}", response, e);
        }
        logger.info("<=== getMark(): get mark, response={}", response);
        return response;
    }

}
