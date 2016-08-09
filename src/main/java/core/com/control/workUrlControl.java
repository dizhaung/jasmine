package core.com.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wangjianan on 16-4-10.
 */
@Controller
//@RequestMapping(value = "work")
public class workUrlControl {

    //@RequestMapping(value = "index", method = RequestMethod.GET)
    private String toIndex() {
        return "work/index";
    }
}
