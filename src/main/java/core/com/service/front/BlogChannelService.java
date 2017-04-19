package core.com.service.front;

import core.com.model.BlogChannel;
import core.com.model.lend.AddChannelReq;
import core.com.model.lend.AddChannelResp;
import core.com.model.lend.BlogChannelMap;

import java.util.List;

/**
 * service
 * Created by wangjianan on 16-8-30.
 */
public interface BlogChannelService {
    List<BlogChannel> queryBlogChannel();
    List<BlogChannelMap> queryBlogChannelGroup();

    AddChannelResp addBlogChannel(AddChannelReq addChannelReq);

    int delete(String channelGid);
}
