package core.blog.control;

import core.com.service.front.SiteMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * do SiteMap
 *
 * Created by wangjianan on 17-6-6.
 */
@Controller
public class SiteMapControl {

    @Autowired
    private SiteMapService siteMapService;

    @RequestMapping(value = "/doSiteMap")
    public void doSiteMapXml() {
        siteMapService.doSiteMapXml();
    }
}
