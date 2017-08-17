package core.com.service;

import core.com.model.lend.IndexInfoReq;
import org.springframework.ui.Model;

/**
 * Created by wangjianan on 17-8-3.
 */
public interface BaseService {

    Model indexInfo(Model model, IndexInfoReq indexInfoReq);
}
