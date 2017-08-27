package core.com.service.impl;

import core.com.service.BaseService;
import core.com.model.BlogChannel;
import core.com.model.lend.BlogChannelMap;
import core.com.model.lend.BlogInfo;
import core.com.model.lend.IndexInfoReq;
import core.com.model.lend.MarkPanelResponse;
import core.com.service.BlogChannelService;
import core.com.service.BlogMarkService;
import core.com.service.BlogService;
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
}
