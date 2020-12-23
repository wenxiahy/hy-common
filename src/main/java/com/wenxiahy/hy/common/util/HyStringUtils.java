package com.wenxiahy.hy.common.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-15
 */
public class HyStringUtils {

    /**
     * 判断是否手机号码
     *
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            return false;
        }

        return phone.matches("^1[3456789]\\d{9}$");
    }

    /**
     * 异或加密
     *
     * @param s
     * @return
     */
    public static String xorEncry(String s) {
        byte[] source = s.getBytes();
        // 每个字节与2做异或操作
        for (int i = 0; i < source.length; i++) {
            int j = (int) source[i] ^ 2;
            source[i] = (byte) j;
        }

        return new String(source);
    }
}
