package core.com.control;

import core.com.model.LightningResponse;
import core.com.service.front.FriendService;
import core.com.utils.ErrorCode;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * friend api
 *
 * Created by wangjianan on 17-4-19.
 */
@RestController
@RequestMapping(value = "/friend")
public class FriendController {
    private static final Logger logger = LoggerFactory.getLogger(FriendController.class);

    @Autowired
    private FriendService friendService;

    @RequestMapping(value = "/getFriend", method = RequestMethod.POST)
    private LightningResponse getFriend() {
        logger.info("===> getFriend(): get bills");
        LightningResponse response = null;
        try {
            response = Utility.getSuccessResp(friendService.getFriendInfo());
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("getFriend(): error, response={}, exception={}", response, e);
        }

        logger.info("<=== getFriend(): get bills, response={}", response);
        return response;
    }
}
