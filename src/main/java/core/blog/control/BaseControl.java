package core.blog.control;

import core.com.model.BlogChannel;
import core.com.model.lend.*;
import core.com.service.front.BlogChannelService;
import core.com.service.front.BlogMarkService;
import core.com.service.front.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * IndexControl
 * <p>
 * Created by wangjianan on 17-5-30.
 */
@Controller
public class BaseControl {
    private static final Logger logger = LoggerFactory.getLogger(BaseControl.class);

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogChannelService blogChannelService;

    @Autowired
    private BlogMarkService blogMarkService;

    @RequestMapping(value = "/")
    private String index(Model model) {
        logger.info("===> index(): get bills");
        BaseInfoResponse response = null;
        try {
            response = blogService.getIndexInfo();

            IndexInfoReq indexInfoReq = new IndexInfoReq();
            List<BlogChannelMap> channelMapList = blogChannelService.queryBlogChannelGroup();
            List<BlogInfo> infoList = blogService.getBlogInfo(indexInfoReq);
            List<BlogChannel> channelList = blogChannelService.queryBlogChannel();
            List<MarkPanelResponse> markList = blogMarkService.getBlogMarkStatistics();

            model.addAttribute("channelList", channelList);
            model.addAttribute("markList", markList);
            model.addAttribute("channelMapList", channelMapList);
            model.addAttribute("infoList", infoList);
            model.addAttribute("response", response);
            model.addAttribute("type", "yes");
        } catch (Exception e) {
            logger.error("index(): error, response={}, exception={}", response, e);
            return "404.ftl";
        }

        logger.info("<=== index(): get bills, response={}", response);
        return "index.ftl";
    }

    @RequestMapping(value = "/view/{gid}")
    private String view(Model model, @PathVariable("gid") String gid) {
        logger.info("===> view(): to view, gid={}", gid);
        IndexDetailResp indexDetailResp = null;
        try {
            IndexDetailReq indexDetailReq = new IndexDetailReq();
            indexDetailReq.setBlogGid(gid);
            indexDetailResp = blogService.getBlogDetail(indexDetailReq);
            List<BlogChannel> channelList = blogChannelService.queryBlogChannel();

            model.addAttribute("channelList", channelList);
            model.addAttribute("blog", indexDetailResp);
            model.addAttribute("type", "no");
        } catch (Exception e) {
            logger.error("view(): error, response={}, exception={}", indexDetailResp, e);
            return "404.ftl";
        }

        logger.info("<=== view(): to view, response={}", indexDetailResp);
        return "index.ftl";
    }
}
