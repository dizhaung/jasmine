package core.com.control;

import core.com.model.LightningResponse;
import core.com.model.lend.AddChannelReq;
import core.com.model.lend.IndexInfoReq;
import core.com.service.front.BlogChannelService;
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
 * app
 * Created by wangjianan on 16-8-30.
 */
@RestController
@RequestMapping(value = "/channel")
public class BlogChannelController {
    private static final Logger logger = LoggerFactory.getLogger(BlogChannelController.class);

    @Autowired
    private BlogChannelService blogChannelService;

    @RequestMapping(value = "/getChannel", method = RequestMethod.POST)
    private LightningResponse getChannel(@RequestBody IndexInfoReq indexInfoReq) {
        logger.info("===> getChannel(): get channel, indexInfoReq={}", indexInfoReq);
        LightningResponse response = null;
        try {
            response = Utility.getSuccessResp(blogChannelService.queryBlogChannel());
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("getChannel(): error, response={}, exception={}", response, e);
        }
        logger.info("<=== getChannel(): get channel, response={}", response);
        return response;
    }

    @RequestMapping(value = "/group", method = RequestMethod.POST)
    private LightningResponse getChannelByGroup() {
        logger.info("===> getChannel(): get getChannelByGroup");
        LightningResponse response = null;
        try {
            response = Utility.getSuccessResp(blogChannelService.queryBlogChannelGroup());
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("getChannel(): error, response={}, exception={}", response, e);
        }
        logger.info("<=== getChannel(): get getChannelByGroup, response={}", response);
        return response;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private LightningResponse add(@RequestBody AddChannelReq addChannelReq) {
        logger.info("===> add(): get add");
        LightningResponse response = null;
        try {
            response = Utility.getSuccessResp(blogChannelService.addBlogChannel(addChannelReq));
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("add(): error, response={}, exception={}", response, e);
        }
        logger.info("<=== add(): get add, response={}", response);
        return response;
    }
}
