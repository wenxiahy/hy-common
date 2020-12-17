package com.wenxiahy.hy.common.util;

import java.util.Base64;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-17
 */
public class Base64Utils {

    /**
     * 加密字符串为base64
     * <p>
     * url中的“+”全部替换成“-”，“/”全部替换成“_”
     *
     * @param s
     * @return
     * @throws Exception
     */
    public static String encryptUrlSafeBase64(String s) throws Exception {
        String base64str = new String(Base64.getEncoder().encode(s.getBytes("utf-8")), "utf-8");
        base64str = base64str
                .replace("\n", "")
                .replace("\r", "")
                .replace('+', '-')
                .replace('/', '_');
        return base64str;
    }

    /**
     * 加密字符串为base64
     *
     * @param s
     * @return
     * @throws Exception
     */
    public static String encryptNormalBase64(String s) throws Exception {
        String base64str = new String(Base64.getEncoder().encode(s.getBytes("utf-8")), "utf-8");
        base64str = base64str
                .replace("\n", "")
                .replace("\r", "");
        return base64str;
    }

    /**
     * 加密byte为base64
     * <p>
     * url中的“+”全部替换成“-”，“/”全部替换成“_”
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String encryptUrlSafeBase64(byte[] bytes) throws Exception {
        String base64str = new String(Base64.getEncoder().encode(bytes), "utf-8");
        base64str = base64str
                .replace("\n", "")
                .replace("\r", "")
                .replace('+', '-')
                .replace('/', '_');
        return base64str;
    }

    /**
     * 加密byte为base64，不可逆
     * <p>
     * 特殊字符全替换成""，只保留数字和字母
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String encryptBase64(byte[] bytes) throws Exception {
        String base64str = new String(Base64.getEncoder().encode(bytes), "utf-8");
        base64str = base64str
                .replace("\n", "")
                .replace("\r", "")
                .replace("+", "")
                .replace("/", "")
                .replace("-", "")
                .replace("_", "")
                .replace("=", "");
        return base64str;
    }

    /**
     * 加密byte为base64
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String encryptNormalBase64(byte[] bytes) throws Exception {
        String base64str = new String(Base64.getEncoder().encode(bytes), "utf-8");
        base64str = base64str
                .replace("\n", "")
                .replace("\r", "");
        return base64str;
    }

    /**
     * 解密base64字符串
     *
     * @param s
     * @return
     * @throws Exception
     */
    public static String decryptUrlSafeBase64(String s) throws Exception {
        return new String(decryptUrlSafeBase64Byte(s), "utf-8");
    }

    /**
     * 解密base64byte[]
     *
     * @param s
     * @return
     * @throws Exception
     */
    public static byte[] decryptUrlSafeBase64Byte(String s) throws Exception {
        return Base64.getDecoder()
                .decode(s.replace('-', '+').replace('_', '/').getBytes("utf-8"));
    }

    /**
     * 解密base64为byte[]
     *
     * @param s
     * @return
     * @throws Exception
     */
    public static byte[] decryptNormalBase64(String s) throws Exception {
        return Base64.getDecoder().decode(s.getBytes("utf-8"));
    }
}
