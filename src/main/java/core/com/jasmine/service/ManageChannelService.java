package core.com.jasmine.service;

import core.com.jasmine.model.BlogChannel;
import core.com.jasmine.model.manage.AddChannelRequest;

import java.util.List;

/**
 *
 * Created by wangjianan on 16-8-19.
 */
public interface ManageChannelService {

    BlogChannel doChannel(AddChannelRequest addChannelRequest);

    List<BlogChannel> queryChannel();

}
