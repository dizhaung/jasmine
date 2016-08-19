package core.com.service.manage;

import core.com.model.manage.AddChannelRequest;
import core.com.model.manage.AddChannelResponse;

/**
 *
 * Created by wangjianan on 16-8-19.
 */
public interface ManageChannelService {

    AddChannelResponse doChannel(AddChannelRequest addChannelRequest);

}
