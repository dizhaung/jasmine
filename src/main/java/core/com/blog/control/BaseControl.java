package core.com.blog.control;

import core.com.blog.service.IndexBlogService;
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
    private IndexBlogService indexBlogService;

    @RequestMapping(value = "/")
    private String index(Model model) {
        logger.info("===> index(): get bills");
        try {
            model = indexBlogService.indexInfo(model, null, null);
        } catch (Exception e) {
            logger.error("index(): error, response={}, exception={}", e);
            return "404.ftl";
        }

        logger.info("<=== index(): get bills");
        return "index.ftl";
    }

    @RequestMapping(value = "/channel/{channelName}")
    private String indexChannel(Model model, @PathVariable("channelName") String channelName) {

        try {
            model = indexBlogService.indexInfo(model, channelName, null);
        } catch (Exception e) {
            logger.error("index(): error, response={}", e);
            return "404.ftl";
        }
        logger.info("<=== indexChannel(): get bills");
        return "index.ftl";
    }

    @RequestMapping(value = "/mark/{markName}")
    private String indexMark(Model model, @PathVariable("markName") String markName) {

        try {
            model = indexBlogService.indexInfo(model, null, markName);
        } catch (Exception e) {
            logger.error("index(): error, response={}", e);
            return "404.ftl";
        }
        logger.info("<=== indexChannel(): get bills");
        return "index.ftl";
    }

    @RequestMapping(value = "/{id}.html")
    private String view(Model model, @PathVariable("id") Integer id) {
        logger.info("===> view(): to view, id={}", id);
        IndexDetailResp indexDetailResp = null;
        try {
            IndexDetailReq indexDetailReq = new IndexDetailReq();
            indexDetailReq.setBlogId(id);
            indexDetailResp = blogService.getBlogDetail(indexDetailReq);
            List<BlogChannel> channelList = blogChannelService.queryBlogChannel();

            StringBuffer channelMeta = new StringBuffer();
            for (BlogChannel blogChannel : channelList) {
                channelMeta.append(blogChannel.getName());
            }

            model.addAttribute("channelList", channelList);
            model.addAttribute("blog", indexDetailResp);
            model.addAttribute("channel_meta", channelMeta);
            model.addAttribute("type", "no");
        } catch (Exception e) {
            logger.error("view(): error, response={}, exception={}", indexDetailResp, e);
            return "404.ftl";
        }

        logger.info("<=== view(): to view, response={}", indexDetailResp);
        return "index.ftl";
    }
}
