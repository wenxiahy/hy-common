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
}
