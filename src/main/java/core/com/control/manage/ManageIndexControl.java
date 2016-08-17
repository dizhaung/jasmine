package core.com.control.manage;

import core.com.model.LightningResponse;
import core.com.model.manage.ManageIndexReq;
import core.com.service.manage.ManageIndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by wangjianan on 16-7-4.
 */
@RestController
public class ManageIndexControl {
    private static final Logger logger = LoggerFactory.getLogger(ManageIndexControl.class);

    @Autowired
    private ManageIndexService manageIndexService;

    @RequestMapping(value = "/manage/getBills", method = RequestMethod.POST)
    private LightningResponse getBlogData(@RequestBody ManageIndexReq manageIndexReq) {
        logger.info("===> manage getBlogData(): manageIndexReq={}", manageIndexReq);
        LightningResponse response = null;

        try {
            response = manageIndexService.queryBlogByType(manageIndexReq);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        logger.info("<=== manage getBlogData(): response={}", response);
        return response;
    }
}
