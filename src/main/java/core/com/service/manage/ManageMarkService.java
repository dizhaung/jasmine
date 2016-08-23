package core.com.service.manage;

import core.com.model.BlogMark;
import core.com.model.manage.AddMarkRequest;

import java.util.List;

/**
 * Created by wangjianan on 16-8-23.
 */
public interface ManageMarkService {

    BlogMark doMark(AddMarkRequest addMarkRequest);

    List<BlogMark> queryMark();
}
