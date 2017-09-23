package core.com.jasmine.service;

import core.com.jasmine.model.BlogChannel;
import core.com.jasmine.model.lend.AddChannelReq;
import core.com.jasmine.model.lend.AddChannelResp;
import core.com.jasmine.model.lend.BlogChannelMap;

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
