package core.com.control;

import core.com.model.LightningResponse;
import core.com.model.lend.IndexInfoReq;
import core.com.service.front.BlogService;
import core.com.utils.ErrorCode;
import core.com.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangjianan on 2016/1/28.
 */
@RestController
public class IndexControl {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/static/getBlogData", method = RequestMethod.POST)
    private LightningResponse getBlogData(@RequestBody IndexInfoReq indexInfoReq) {
        LightningResponse response = null;
        try {
            response = blogService.getIndexInfo(indexInfoReq);
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            e.printStackTrace();
        }
        return response;
    }
}
