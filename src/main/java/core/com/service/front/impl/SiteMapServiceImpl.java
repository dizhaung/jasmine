package core.com.service.front.impl;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import core.com.dao.BlogLoanDao;
import core.com.model.BlogLoan;
import core.com.model.common.SiteMapXml;
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
import org.springframework.util.CollectionUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by wangjianan on 17-6-5.
 */
@Service
public class SiteMapServiceImpl implements SiteMapService {
    private static final Logger logger = LoggerFactory.getLogger(SiteMapServiceImpl.class);

    @Autowired
    private BlogLoanDao blogLoanDao;

    @Override
    public String siteMapXml() {

        Document document = DocumentHelper.createDocument();
        Element urlSet = document.addElement("urlset");
        urlSet.addAttribute("xmlns ", "http://www.sitemaps.org/schemas/sitemap/0.9"); // "xmlns
        urlSet.addAttribute("xmlns", "http://www.sitemaps.org/schemas/sitemap/0.9");
        urlSet.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        urlSet.addAttribute("xsi:schemaLocation", "http://www.sitemaps.org/schemas/sitemap/0.9 " + "http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd");

        List<BlogLoan> blogLoanList = blogLoanDao.queryBlogLoan();
        if (!CollectionUtils.isEmpty(blogLoanList)) {
            for (BlogLoan loan : blogLoanList) {
                Integer id = loan.getId();
                int updateTime = loan.getUpdateTime();
                Element url = urlSet.addElement("url");
                Element loc = url.addElement("loc");
                Element priority = url.addElement("priority");
                Element lastMod = url.addElement("lastmod");

                loc.setText(getUrl(id));
                priority.setText(String.valueOf(0.8));
                lastMod.setText(Utility.getDateFormat2(updateTime));
            }
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter("./sitemap.xml");
            XMLWriter xmlWriter = new XMLWriter(writer);
            xmlWriter.write(document);
            String response = xmlWriter.toString();
            xmlWriter.close();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getUrl(Integer id) {
        return "http://www.oopmind.com/" + String.valueOf(id) + ".html";
    }

}
