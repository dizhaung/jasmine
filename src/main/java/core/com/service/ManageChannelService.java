package core.com.service;

import core.com.model.BlogChannel;
import core.com.model.manage.AddChannelRequest;
import core.com.model.manage.AddChannelResponse;

import java.util.List;

/**
 *
 * Created by wangjianan on 16-8-19.
 */
public interface ManageChannelService {

    BlogChannel doChannel(AddChannelRequest addChannelRequest);

    List<BlogChannel> queryChannel();

}
