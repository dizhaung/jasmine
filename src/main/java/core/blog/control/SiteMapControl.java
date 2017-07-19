package core.blog.control;

import core.com.service.front.BaiduUrlService;
import core.com.service.front.SiteMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    private BaiduUrlService baiduUrlService;

    @RequestMapping(value = "/sitemap.xml")
    public String siteMapXml(Model model) {
        model.addAttribute("siteMap", siteMapService.siteMapXml());
        return "sitemap.xml";
    }

    @RequestMapping(value = "/push")
    public String push() {
        baiduUrlService.pushUrl();
        return "success";
    }
}
