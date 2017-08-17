package core.com.control;

import core.com.exception.CoreException;
import core.com.model.lend.IndexInfoReq;
import core.com.service.BaseService;
import core.com.model.BlogChannel;
import core.com.model.lend.IndexDetailReq;
import core.com.model.lend.IndexDetailResp;
import core.com.service.BlogChannelService;
import core.com.service.BlogService;
import core.com.utils.ErrorCode;
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
            indexInfoReq.setPageSize(10);
            model = baseService.indexInfo(model, indexInfoReq);
        } catch (Exception e) {
            logger.error("index(): error, response={}, exception={}", e);
            return "404.ftl";
        }

        logger.info("<=== index(): get bills");
        return "index.ftl";
    }

    @RequestMapping(value = "/channel/{channelName}")
    private String indexChannel(Model model, @PathVariable("channelName") String channelName, @RequestParam(value = "page", required = false) Integer page) {

        try {
            IndexInfoReq indexInfoReq = new IndexInfoReq();
            indexInfoReq.setPageSize(10);
            indexInfoReq.setPageIndex(page);
            indexInfoReq.setChannelGid(channelName);
            model = baseService.indexInfo(model, indexInfoReq);
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
            indexInfoReq.setMarkGid(markName);
            indexInfoReq.setPageSize(10);
            indexInfoReq.setPageIndex(page);
            model = baseService.indexInfo(model, indexInfoReq);
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
