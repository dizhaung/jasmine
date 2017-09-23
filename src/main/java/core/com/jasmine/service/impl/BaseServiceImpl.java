package core.com.jasmine.service.impl;

import core.com.jasmine.dao.BlogMarkDao;
import core.com.jasmine.dao.ConfigBlogMarkDao;
import core.com.jasmine.model.BlogMark;
import core.com.jasmine.model.ConfigBlogMark;
import core.com.jasmine.model.lend.*;
import core.com.jasmine.service.BaseService;
import core.com.jasmine.model.BlogChannel;
import core.com.jasmine.service.BlogChannelService;
import core.com.jasmine.service.BlogMarkService;
import core.com.jasmine.service.BlogService;
import core.com.jasmine.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * 首页service
 * Created by wangjianan on 17-8-3.
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogChannelService blogChannelService;

    @Autowired
    private BlogMarkService blogMarkService;

    @Autowired
    private ConfigBlogMarkDao configBlogMarkDao;

    @Autowired
    private BlogMarkDao blogMarkDao;

    @Override
    public Model indexInfo(Model model, IndexInfoReq indexInfoReq) {

        List<BlogChannelMap> channelMapList = blogChannelService.queryBlogChannelGroup();
        List<BlogInfo> infoList = blogService.queryInfoByLimit(indexInfoReq);
        List<BlogChannel> channelList = blogChannelService.queryBlogChannel();
        List<MarkPanelResponse> markList = blogMarkService.getBlogMarkStatistics();
        int totalPage = blogService.queryInfoCount(indexInfoReq);

        model.addAttribute("channelList", channelList);
        model.addAttribute("markList", markList);
        model.addAttribute("channelMapList", channelMapList);
        model.addAttribute("infoList", infoList);
        model.addAttribute("response", blogService.getIndexInfo());
        model.addAttribute("totalPage", totalPage % indexInfoReq.getPageSize() > 0 ? totalPage / indexInfoReq.getPageSize() + 1 : totalPage / indexInfoReq.getPageSize());
        model.addAttribute("type", "1");

        return model;
    }

    @Override
    public Model indexView(Model model, IndexDetailReq indexDetailReq) {

        IndexDetailResp indexDetailResp = blogService.getBlogDetail(indexDetailReq);
        List<BlogChannel> channelList = blogChannelService.queryBlogChannel();

        List<ConfigBlogMark> configBlogMarkList = configBlogMarkDao.queryConfigByBlogGid(indexDetailResp.getGid());
        List<BlogMark> blogMarkList = blogMarkDao.queryMarkByGidList(Utility.getMarkList(configBlogMarkList));

        model.addAttribute("channelList", channelList);
        model.addAttribute("blog", indexDetailResp);
        model.addAttribute("markList", blogMarkList);

        return model;
    }
}
