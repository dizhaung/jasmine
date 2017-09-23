package core.com.jasmine.service;

import core.com.jasmine.model.BlogMark;
import core.com.jasmine.model.manage.AddMarkRequest;

import java.util.List;

/**
 * Created by wangjianan on 16-8-23.
 */
public interface ManageMarkService {

    BlogMark doMark(AddMarkRequest addMarkRequest);

    List<BlogMark> queryMark();
}
