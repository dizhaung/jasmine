package core.com.cotton.control;

import core.com.cotton.service.WxService;
import core.com.cotton.service.impl.WxServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * wenxin
 *
 * Created by wangjianan on 17-9-23.
 */
@RestController
public class WxController {
    private static final Logger logger = LoggerFactory.getLogger(WxServiceImpl.class);

    @Autowired
    private WxService wxService;

    @RequestMapping(value = "wx", method = RequestMethod.GET)
    private String wx(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp, @RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr) {
        logger.info("wx(): signature={}", signature);
        if (wxService.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return null;
    }

}
