package core.com.jasmine.service.impl;

import core.com.jasmine.dao.BlogMarkDao;
import core.com.jasmine.model.lend.MarkPanelResponse;
import core.com.jasmine.model.mapper.BlogMarkStatistics;
import core.com.jasmine.service.BlogMarkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * app
 * Created by wangjianan on 16-8-31.
 */
@Service
public class BlogMarkServiceImpl implements BlogMarkService {
    private static final Logger logger = LoggerFactory.getLogger(BlogMarkServiceImpl.class);

    @Autowired
    private BlogMarkDao blogMarkDao;

    @Override
    public List<MarkPanelResponse> getBlogMarkStatistics() {
        logger.info("getBlogMarkStatistics(): begin;");
        List<MarkPanelResponse> responseList = new ArrayList<>();
        List<BlogMarkStatistics> blogMarkStatisticsList = blogMarkDao.getBlogMarkStatistics();
        Collections.sort(blogMarkStatisticsList);

        for (BlogMarkStatistics mark : blogMarkStatisticsList) {
            MarkPanelResponse response = new MarkPanelResponse();
            response.setName(mark.getName());
            response.setMarkGid(mark.getGid());
            response.setCount(mark.getCount());
            responseList.add(response);
        }

        logger.info("getBlogMarkStatistics(): responseList={}", responseList);
        return responseList;
    }
}
