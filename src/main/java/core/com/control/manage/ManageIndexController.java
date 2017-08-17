package core.com.control.manage;

import core.com.model.LightningResponse;
import core.com.model.manage.ManageIndexReq;
import core.com.service.ManageIndexService;
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
 * Created by wangjianan on 16-7-4.
 */
@RestController
public class ManageIndexController {
    private static final Logger logger = LoggerFactory.getLogger(ManageIndexController.class);

    @Autowired
    private ManageIndexService manageIndexService;

    @RequestMapping(value = "/manage/getBills", method = RequestMethod.POST)
    private LightningResponse getBlogData(@RequestBody ManageIndexReq manageIndexReq) {
        logger.info("===> manage getBlogData(): manageIndexReq={}", manageIndexReq);
        LightningResponse response = null;

        try {
            response = Utility.getSuccessResp( manageIndexService.queryBlogByType(manageIndexReq));
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("channel(): channel is error, exception={}", e);
        } finally {

        }
        logger.info("<=== manage getBlogData(): response={}", response);
        return response;
    }
}
