package core.blog.control;

import core.com.model.common.SiteMapXml;
import core.com.service.front.SiteMapService;
import org.dom4j.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * do SiteMap
 *
 * Created by wangjianan on 17-6-6.
 */
@Controller
public class SiteMapControl {

    @Autowired
    private SiteMapService siteMapService;

    @RequestMapping(value = "/sitemap.xml")
    public String siteMapXml(Model model) {
        model.addAttribute("siteMap", siteMapService.siteMapXml());
        return "sitemap.xml";
    }
}
