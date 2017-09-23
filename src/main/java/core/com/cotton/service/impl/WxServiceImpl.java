package core.com.cotton.service.impl;

import core.com.cotton.service.WxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by wangjianan on 17-9-23.
 */
@Service
public class WxServiceImpl implements WxService {
    private static final Logger logger = LoggerFactory.getLogger(WxServiceImpl.class);

    // 与接口配置信息中的 Token 要一致
    private static String token = "39af540691d111e7801800163e300cc7";

    @Override
    public boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[]{token, timestamp, nonce};
        // 将 token、timestamp、nonce 三个参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (String anArr : arr) {
            content.append(anArr);
        }
        MessageDigest md = null;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行 sha1 加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            logger.error("checkSignature(): NoSuchAlgorithmException e={}", e);
        }

        content = null;
        // 将 sha1 加密后的字符串可与 signature 对比，标识该请求来源于微信
        return tmpStr != null && tmpStr.equals(signature.toUpperCase());
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray 参数
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (byte aByteArray : byteArray) {
            strDigest += byteToHexStr(aByteArray);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte 参数
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        return new String(tempArr);
    }
}
