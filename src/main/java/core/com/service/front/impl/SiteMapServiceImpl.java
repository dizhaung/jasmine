package core.com.service.front.impl;

import core.com.dao.BlogLoanDao;
import core.com.model.BlogLoan;
import core.com.service.front.SiteMapService;
import core.com.utils.Utility;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.util.List;

/**
 * Created by wangjianan on 17-6-5.
 */
@Service
public class SiteMapServiceImpl implements SiteMapService {
    private static final Logger logger = LoggerFactory.getLogger(SiteMapServiceImpl.class);

    @Autowired
    private BlogLoanDao blogLoanDao;

    @Override
    public void doSiteMapXml() {
        List<BlogLoan> blogLoanList = blogLoanDao.queryBlogLoan();
        if (blogLoanList != null && blogLoanList.size() > 0) {
            double priority_ = 0.75;
            // 创建文件
            Document document = DocumentHelper.createDocument();
            String str = document.getPath();
            Element urlSet = document.addElement("urlset");

            urlSet.addAttribute("xmlns ", "http://www.sitemaps.org/schemas/sitemap/0.9"); // "xmlns
            // "必须要有空格,否则会报错
            urlSet.addAttribute("xmlns", "http://www.sitemaps.org/schemas/sitemap/0.9");

            urlSet.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");

            urlSet.addAttribute("xsi:schemaLocation", "http://www.sitemaps.org/schemas/sitemap/0.9 " +
                                "http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd");
            for (BlogLoan loan : blogLoanList) {
                String gid = loan.getGid();
                int updateTime = loan.getUpdateTime();
                Element url = urlSet.addElement("url");
                Element loc = url.addElement("loc");
                Element priority = url.addElement("priority");
                Element lastMod = url.addElement("lastmod");
                Element changeFreq = url.addElement("changefreq");

                loc.setText(getUrl(gid));
                priority.setText(String.valueOf(priority_));
                changeFreq.setText("daily");
                lastMod.setText(Utility.getDateFormat2(updateTime));
            }

            try {
                FileWriter writer = new FileWriter("/www/server/jasmine_8080/webapps/ROOT");
                XMLWriter xmlWriter = new XMLWriter(writer);
                xmlWriter.write(document);
                xmlWriter.close();
            } catch (Exception e) {
                logger.error("doSiteMapXml(): do error, exception: ", e);
            }

        }
    }

    private String getUrl(String gid) {
        return "http://www.oopmind.com/view/" + gid;
    }

}
