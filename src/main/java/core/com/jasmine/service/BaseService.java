package core.com.jasmine.service;

import core.com.jasmine.model.lend.IndexDetailReq;
import core.com.jasmine.model.lend.IndexInfoReq;
import org.springframework.ui.Model;

/**
 * Created by wangjianan on 17-8-3.
 */
public interface BaseService {

    Model indexInfo(Model model, IndexInfoReq indexInfoReq);

    Model indexView(Model model, IndexDetailReq indexDetailReq);
}
