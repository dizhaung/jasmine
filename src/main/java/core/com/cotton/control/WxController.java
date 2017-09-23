package core.com.cotton.control;

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

    @RequestMapping(value = "wx", method = RequestMethod.GET)
    private String wx(@RequestParam("signature") String signature, @RequestParam("timestamp") Integer timestamp, @RequestParam("nonce") Integer nonce, @RequestParam("echostr") String echostr) {

        return echostr;
    }

}
