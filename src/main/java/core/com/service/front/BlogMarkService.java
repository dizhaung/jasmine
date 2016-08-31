package core.com.service.front;

import core.com.model.BlogMark;
import core.com.model.lend.MarkPanelResponse;

import java.util.List;

/**
 * Created by wangjianan on 16-8-31.
 */
public interface BlogMarkService {

    List<MarkPanelResponse> getBlogMarkStatistics();
}
