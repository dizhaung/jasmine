package core.com.jasmine.control.manage;

import core.com.jasmine.model.LightningResponse;
import core.com.jasmine.model.manage.AddChannelRequest;
import core.com.jasmine.service.ManageChannelService;
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
 * Created by wangjianan on 16-8-19.
 */
@RestController
@RequestMapping(value = "/manage/channel")
public class ChannelController {
    private static final Logger logger = LoggerFactory.getLogger(ChannelController.class);

    @Autowired
    private ManageChannelService manageChannelService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private LightningResponse channel(@RequestBody AddChannelRequest addChannelRequest) {
        logger.info("===> channel channel(): addChannelRequest={}", addChannelRequest);
        LightningResponse response = null;

        if (addChannelRequest == null || Utility.isBlank(addChannelRequest.getChannelName())) {
            response = Utility.getErrorResponse(ErrorCode.SYS_PARAMETER_ERROR);
            return response;
        }

        try {
            response = Utility.getSuccessResp(manageChannelService.doChannel(addChannelRequest));
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("channel(): channel is error, exception={}", e);
        }
        logger.info("<=== channel channel(): response={}", response);
        return response;
    }

    @RequestMapping(value = "/getChannel", method = RequestMethod.POST)
    private LightningResponse queryChannel() {
        logger.info("===> channel queryChannel():");
        LightningResponse response = null;

        try {
            response = Utility.getSuccessResp(manageChannelService.queryChannel());
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("channel(): channel is error, exception={}", e);
        }
        logger.info("<=== channel queryChannel(): response={}", response);
        return response;
    }

}
