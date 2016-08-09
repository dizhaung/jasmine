package core.com.utils;

import core.com.model.LightningResponse;

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
}
