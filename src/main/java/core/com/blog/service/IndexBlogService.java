package core.com.blog.service;

import org.springframework.ui.Model;

/**
 * Created by wangjianan on 17-8-3.
 */
public interface IndexBlogService {

    Model indexInfo(Model model, String channelName, String markName);
}
