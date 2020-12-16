package com.wenxiahy.hy.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-16
 */
public class DateTimeUtils {

    private static ThreadLocal<DateFormat> ymdhms = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    private static ThreadLocal<DateFormat> ymd = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    /**
     * 格式化日期，格式：yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String formatYMDHMS(Date date) {
        return ymdhms.get().format(date);
    }

    /**
     * 格式化日期，格式：yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String formatYMD(Date date) {
        return ymd.get().format(date);
    }
}
