package core.com.service.front.impl;

import core.com.model.common.BaiduUrlRequest;
import core.com.model.common.BaiduUrlResponse;
import core.com.service.common.VendorHttpClientService;
import core.com.service.front.BaiduUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * baidu send url
 * <p>
 * Created by wangjianan on 17-7-18.
 */
@Service
public class BaiduUrlServiceImpl implements BaiduUrlService {
    private static final Logger logger = LoggerFactory.getLogger(BaiduUrlServiceImpl.class);

    @Autowired
    private VendorHttpClientService vendorHttpClientService;

    @Override
    public void pushUrl() {
        String param = "http://www.oopmind.com/11.html";

        String url = "http://data.zz.baidu.com/urls?site=www.oopmind.com&token=L0IUiGaaBiv3ij5Q&type=original";
        BaiduUrlResponse response = vendorHttpClientService.post(url, Arrays.asList(param), BaiduUrlResponse.class);

        logger.info("pushUrl(): response={}", response);
    }
}
