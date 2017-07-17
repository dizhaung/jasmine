package core.com.service.front.impl;

import core.com.dao.BlogLoanDao;
import core.com.model.BlogLoan;
import core.com.model.common.SiteMapXml;
import core.com.service.front.SiteMapService;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
    public SiteMapXml siteMapXml() {
        List<BlogLoan> blogLoanList = blogLoanDao.queryBlogLoan();
        if (!CollectionUtils.isEmpty(blogLoanList)) {
            SiteMapXml xml = new SiteMapXml();
            List<SiteMapXml.Sitemap> list = new ArrayList<>();
            for (BlogLoan loan : blogLoanList) {
                Integer id = loan.getId();
                int updateTime = loan.getUpdateTime();
                SiteMapXml.Sitemap sitemap = new SiteMapXml.Sitemap();
                sitemap.setLoc(getUrl(id));
                sitemap.setLastmod(Utility.getDateFormat2(updateTime));
                sitemap.setPriority(String.valueOf(0.8));
                list.add(sitemap);
            }
            xml.setSitemapList(list);
            return xml;
        }
        return null;
    }

    private String getUrl(Integer id) {
        return "http://www.oopmind.com/" + String.valueOf(id) + ".html";
    }

}
