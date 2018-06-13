package core.com.jasmine.control;

import core.com.jasmine.model.lend.IndexInfoReq;
import core.com.jasmine.service.BaseService;
import core.com.jasmine.model.BlogChannel;
import core.com.jasmine.model.lend.IndexDetailReq;
import core.com.jasmine.service.BlogChannelService;
import core.com.jasmine.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * IndexControl
 * <p>
 * Created by wangjianan on 17-5-30.
 */
@Controller
public class BaseControl {
    private static final Logger logger = LoggerFactory.getLogger(BaseControl.class);
    private static final int PAGE = 5;

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogChannelService blogChannelService;

    @Autowired
    private BaseService baseService;

    @RequestMapping(value = "/")
    private String index(Model model, @RequestParam(value = "page", required = false) Integer page) {
        logger.info("===> index(): page={}", page);

        try {
            IndexInfoReq indexInfoReq = new IndexInfoReq();
            indexInfoReq.setPageIndex(page == null ? 1 : page);
            indexInfoReq.setPageSize(PAGE);
            model = baseService.indexInfo(model, indexInfoReq);

            model.addAttribute("page", page == null? 1:page);
            model.addAttribute("path", "");
        } catch (Exception e) {
            logger.error("index(): error, response={}, exception={}", e);
            return "404.ftl";
        }

        logger.info("<=== index(): get index, model={}", model);
        return "index.ftl";
    }

    @RequestMapping(value = "/channel/{channelName}")
    private String indexChannel(Model model, @PathVariable("channelName") String channelName, @RequestParam(value = "page", required = false) Integer page) {

        try {
            IndexInfoReq indexInfoReq = new IndexInfoReq();
            indexInfoReq.setPageIndex(page == null ? 1 : page);
            indexInfoReq.setPageSize(PAGE);
            indexInfoReq.setChannelGid(channelName);
            model = baseService.indexInfo(model, indexInfoReq);
            model.addAttribute("page", page == null? 1:page);
            model.addAttribute("path", "/channel/" + channelName);
        } catch (Exception e) {
            logger.error("index(): error, response={}", e);
            return "404.ftl";
        }
        logger.info("<=== indexChannel(): get bills");
        return "index.ftl";
    }

    @RequestMapping(value = "/mark/{markName}")
    private String indexMark(Model model, @PathVariable("markName") String markName, @RequestParam(value = "page", required = false) Integer page) {

        try {
            IndexInfoReq indexInfoReq = new IndexInfoReq();
            indexInfoReq.setPageIndex(page == null ? 1 : page);
            indexInfoReq.setMarkGid(markName);
            indexInfoReq.setPageSize(PAGE);
            model = baseService.indexInfo(model, indexInfoReq);
            model.addAttribute("page", page == null? 1:page);
            model.addAttribute("path", "/mark/" + markName);
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

        try {
            IndexDetailReq indexDetailReq = new IndexDetailReq();
            indexDetailReq.setBlogId(id);
            baseService.indexView(model, indexDetailReq);
            model.addAttribute("type", "0");
        } catch (Exception e) {
            logger.error("view(): error exception={}", e);
            return "404.ftl";
        }

        return "index.ftl";
    }

    @RequestMapping(value = "/weixin")
    private String weixin(Model model) {

        List<BlogChannel> channelList = blogChannelService.queryBlogChannel();

        StringBuffer channelMeta = new StringBuffer();
        for (BlogChannel blogChannel : channelList) {
            channelMeta.append(blogChannel.getName());
        }
        model.addAttribute("channel_meta", channelMeta);
        model.addAttribute("channelList", channelList);
        model.addAttribute("type", "2");
        return "index.ftl";
    }
}
