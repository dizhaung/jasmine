package core.com.control;

import core.com.model.LightningResponse;
import core.com.model.lend.AddChannelReq;
import core.com.model.lend.IndexInfoReq;
import core.com.service.BlogChannelService;
import core.com.utils.ErrorCode;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    private LightningResponse delete(@RequestParam String channelGid) {
        logger.info("===> delete(): delete channel, channelGid={}", channelGid);
        LightningResponse response = null;
        try {
            response = Utility.getSuccessResp(blogChannelService.delete(channelGid));
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("delete(): error, response={}, exception={}", response, e);
        }
        logger.info("<=== delete(): delete channel, response={}", response);
        return response;
    }
}
