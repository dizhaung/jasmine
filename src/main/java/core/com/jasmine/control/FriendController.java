package core.com.jasmine.control;

import core.com.jasmine.model.LightningResponse;
import core.com.jasmine.model.manage.AddFriendReq;
import core.com.jasmine.service.FriendService;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private LightningResponse add(@RequestBody AddFriendReq addFriendReq) {
        logger.info("===> add(): add={}", addFriendReq);
        LightningResponse response = null;
        try {
            response = Utility.getSuccessResp(friendService.add(addFriendReq));
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("add(): error, response={}, exception={}", response, e);
        }

        logger.info("<=== add(): get bills, response={}", response);
        return response;
    }
}
