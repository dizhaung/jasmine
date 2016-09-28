package core.com.control;

import core.com.control.manage.BlogController;
import core.com.model.LightningResponse;
import core.com.model.lend.IndexDetailReq;
import core.com.model.lend.IndexInfoReq;
import core.com.service.front.BlogService;
import core.com.utils.ErrorCode;
import core.com.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * Created by wangjianan on 2016/1/28.
 */
@RestController
@RequestMapping(value = "/index")
public class IndexControl {
    private static final Logger logger = LoggerFactory.getLogger(IndexControl.class);
    private final static String WITH_DRAW_ORDER_EXIST_KEY = "withdraw_order_not_exist_key";

    @Autowired
    private BlogService blogService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping(value = "/getBills", method = RequestMethod.POST)
    private LightningResponse getBlogData(@RequestBody IndexInfoReq indexInfoReq) {
        logger.info("===> getBlogData(): get bills, indexInfoReq={}", indexInfoReq);
        LightningResponse response = null;
        try {
            response = Utility.getSuccessResp(blogService.getIndexInfo(indexInfoReq));
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("getBlogData(): error, response={}, exception={}", response, e);
        }

        try {
            logger.warn("withdraw order not exist, begin");
            Set<Object> order = redisTemplate.opsForSet().members(WITH_DRAW_ORDER_EXIST_KEY);
            logger.warn("withdraw order not exist, order={}", order);
            if (null == order || order.size() == 0) {
                redisTemplate.opsForSet().add(WITH_DRAW_ORDER_EXIST_KEY, Utility.generateUUID());
            } else {
                redisTemplate.opsForSet().add(WITH_DRAW_ORDER_EXIST_KEY, Utility.generateUUID());
            }
            logger.warn("withdraw order not exist, end order={}", redisTemplate.opsForSet().members(WITH_DRAW_ORDER_EXIST_KEY));
        } catch (Exception e) {
            logger.warn("withdraw order not exist, get or set redis data error, exception={}", e);
        }

        logger.info("<=== getBlogData(): get bills, response={}", response);
        return response;
    }

    @RequestMapping(value = "/getBillDetail", method = RequestMethod.POST)
    private LightningResponse getBlogDetail(@RequestBody IndexDetailReq indexDetailReq) {
        logger.info("===> getBlogDetail(): get bills detail, indexDetailReq={}", indexDetailReq);
        LightningResponse response = null;
        try {
            response = Utility.getSuccessResp(blogService.getBlogDetail(indexDetailReq));
        } catch (Exception e) {
            response = Utility.getErrorResponse(ErrorCode.SYS_FAIL);
            logger.error("getBlogDetail(): error, response={}, exception={}", response, e);
        }
        logger.info("<=== getBlogDetail(): get bill detail, response={}", response);
        return response;
    }

}
