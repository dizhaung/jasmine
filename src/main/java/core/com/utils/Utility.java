package core.com.utils;

import core.com.model.ConfigBlogMark;
import core.com.model.LightningResponse;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wangjianan on 2016/2/17.
 */
public class Utility {

    /**
     * Convert current time into int type. used for create_time/update time
     * @param
     * @return timestamp
     */
    public static int getCurrentTimeStamp() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static LightningResponse getErrorResponse() {
        LightningResponse response = new LightningResponse();
        response.setStatus(-1);
        return response;
    }

    /**
     * 转化倒计时时间
     *
     * @param createTime
     * @return
     */
    public static String getDateTime(int createTime) {
        int currentTimeStamp = Utility.getCurrentTimeStamp();
        int time = currentTimeStamp - createTime;
        String resultStr = "";
        if (time < Constants.SECONDS_OF_ONE_DAY) {
            if (time < (60 * 60)) {
                if (time < 60) {
                    resultStr = time + " 秒";
                } else {
                    resultStr = time / 60 + " 分钟";
                }
            } else {
                resultStr = time / (60 * 60) + " 小时";
            }
        } else {
            resultStr = time / Constants.SECONDS_OF_ONE_DAY + " 天";
        }
        return resultStr;
    }

    /**
     * generate random UUID, eg:d17e0ec1-3dda-47cc-8643-e516afa08a36
     *
     * @return new uuid
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static LightningResponse getSuccessResp(Object content) {
        LightningResponse resp = new LightningResponse();
        resp.setStatus(ErrorCode.SYS_SUCCESS);
        resp.setMessage("成功");
        resp.setContent(content);
        return resp;
    }

    public static LightningResponse getErrorResponse(int status) {
        LightningResponse resp = new LightningResponse();
        resp.setStatus(status);
        switch (status) {
            case ErrorCode.SYS_FAIL: {
                resp.setMessage("失败");
                break;
            }
            case ErrorCode.SYS_PARAMETER_ERROR: {
                resp.setMessage("系统繁忙，请稍后尝试");
                break;
            }
            default:{
                resp.setMessage("system error");
                break;
            }
        }
        return resp;
    }

    public static boolean isNotBlank(String str) {
        return (!isBlank(str));
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    public static String getSomeArticles(String content) {
        if (content != null) {
//            String result = content.s
            return null;
        }
        return null;
    }

    /**
     *  int --> '2016-10-01 13:28:90'
     * @param time
     * @return
     */
    public static String getDateFormat(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  format.format(new Date(time * 1000));
    }

    /**
     *  int --> '2016-10-01'
     * @param time
     * @return
     */
    public static String getDateFormat2(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return  format.format(new Date(time * 1000));
    }

    public static String getUrl(Integer id) {
        return "http://www.oopmind.com/" + String.valueOf(id) + ".html";
    }

    public static List<String> getMarkList(List<ConfigBlogMark> configBlogMarkList) {
        List<String> result = null;
        if (configBlogMarkList != null && configBlogMarkList.size() > 0) {
            result = new ArrayList<>();
            for (ConfigBlogMark config : configBlogMarkList) {
                result.add(config.getMarkGid());
            }
        }
        return result;
    }
}
