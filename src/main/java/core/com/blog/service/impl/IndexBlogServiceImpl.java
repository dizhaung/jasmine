package core.com.blog.service.impl;

import core.com.blog.service.IndexBlogService;
import core.com.model.BlogChannel;
import core.com.model.lend.BlogChannelMap;
import core.com.model.lend.BlogInfo;
import core.com.model.lend.IndexInfoReq;
import core.com.model.lend.MarkPanelResponse;
import core.com.service.front.BlogChannelService;
import core.com.service.front.BlogMarkService;
import core.com.service.front.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * 首页service
 * Created by wangjianan on 17-8-3.
 */
@Service
public class IndexBlogServiceImpl implements IndexBlogService {

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogChannelService blogChannelService;

    @Autowired
    private BlogMarkService blogMarkService;

    @Override
    public Model indexInfo(Model model, String channelName, String markName) {

        IndexInfoReq indexInfoReq = new IndexInfoReq();
        if (channelName != null) {
            indexInfoReq.setChannelGid(channelName);
        }

        if (markName != null) {
            indexInfoReq.setMarkGid(markName);
        }
        List<BlogChannelMap> channelMapList = blogChannelService.queryBlogChannelGroup();
        List<BlogInfo> infoList = blogService.getBlogInfo(indexInfoReq);
        List<BlogChannel> channelList = blogChannelService.queryBlogChannel();
        List<MarkPanelResponse> markList = blogMarkService.getBlogMarkStatistics();

        model.addAttribute("channelList", channelList);
        model.addAttribute("markList", markList);
        model.addAttribute("channelMapList", channelMapList);
        model.addAttribute("infoList", infoList);
        model.addAttribute("response", blogService.getIndexInfo());
        model.addAttribute("type", "yes");

        return model;
    }
}
