package core.com.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WangJianan on 2015/12/15.
 */
@RestController
public class TestControl {

//    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String toIndex() {
        return "SUCCESS";
    }
}
