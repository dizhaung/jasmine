package core.com.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangjianan on 2016/2/16.
 */
@Controller
public class KernelControl {

    @RequestMapping(value = "index")
    private String toIndex() {
        return "index";
    }

    @RequestMapping(value = "workIndex")
    private String toWorkIndex() {
        return "workIndex";
    }

}
