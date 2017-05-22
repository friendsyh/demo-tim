package com.tim.web.gateway.utils;

import com.tim.web.gateway.constants.GatewayConstant;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

public class SecurityUtil {

    private static final Log logger = LogFactory.getLog(SecurityUtil.class);

    /**
     * generates hash key
     *
     * @param msg
     * @param appSecret
     * @return string
     */
    public static String sign(String msg, String appSecret) {
        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec((appSecret).getBytes(GatewayConstant.CHAR_UTF_8)
                    , GatewayConstant.HASH_ALGORITHM);
            Mac mac = Mac.getInstance(GatewayConstant.HASH_ALGORITHM);
            mac.init(key);
            final byte[] bytes = mac.doFinal(msg.getBytes(GatewayConstant.CHAR_ASCII));
            StringBuffer hash = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xFF & bytes[i]);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }
            digest = hash.toString();
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        } catch (InvalidKeyException e) {
            logger.error(e);
        } catch (NoSuchAlgorithmException e) {
            logger.error(e);
        }
        return digest;
    }

    public static String toQueryString(Map<String, String> data) {
        Map<String, String> dataMap = new TreeMap<>(data);
        String queryString = "";
        try {
            StringBuffer params = new StringBuffer();
            for (Map.Entry<String, String> pair : dataMap.entrySet()) {
                params.append(URLEncoder.encode(pair.getKey(), GatewayConstant.CHAR_UTF_8) + "=");
                params.append(URLEncoder.encode(pair.getValue(), GatewayConstant.CHAR_UTF_8) + "&");
            }
            if (params.length() > 0) {
                params.deleteCharAt(params.length() - 1);
            }
            queryString = params.toString();
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        }
        return queryString;
    }
}
