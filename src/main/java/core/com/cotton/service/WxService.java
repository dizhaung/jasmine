package core.com.cotton.service;

/**
 * Created by wangjianan on 17-9-23.
 */
public interface WxService {

    boolean checkSignature(String signature, String timestamp, String nonce);
}
