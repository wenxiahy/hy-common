package com.wenxiahy.hy.common.support;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-15
 */
public class ResponseMapper {

    private ResponseMapper() {

    }

    /**
     * 查无数据
     *
     * @param <T>
     * @return
     */
    public static <T> HyResponse<T> noData() {
        return new HyResponse<>(HyResponse.NO_DATA_CODE, HyResponse.NO_DATA_MESSAGE);
    }

    /**
     * 无权访问
     *
     * @param <T>
     * @return
     */
    public static <T> HyResponse<T> noAccess() {
        return new HyResponse<>(HyResponse.NO_ACCESS_CODE, HyResponse.NO_ACCESS_MESSAGE);
    }

    /**
     * 参数错误
     *
     * @param <T>
     * @return
     */
    public static <T> HyResponse<T> errorArgument() {
        return new HyResponse<>(HyResponse.ERROR_ARGUMENT_CODE, HyResponse.ERROR_ARGUMENT_MESSAGE);
    }

    /**
     * 参数错误
     *
     * @param <T>
     * @return
     */
    public static <T> HyResponse<T> errorArgument(String errorMessage) {
        return new HyResponse<>(HyResponse.ERROR_ARGUMENT_CODE,
                StringUtils.isBlank(errorMessage) ? HyResponse.ERROR_ARGUMENT_MESSAGE : errorMessage);
    }

    /**
     * 失败
     *
     * @param <T>
     * @return
     */
    public static <T> HyResponse<T> error() {
        return new HyResponse<>(HyResponse.ERROR_CODE, HyResponse.ERROR_MESSAGE);
    }

    /**
     * 失败
     *
     * @param errorMessage
     * @param <T>
     * @return
     */
    public static <T> HyResponse<T> error(String errorMessage) {
        return new HyResponse<>(HyResponse.ERROR_CODE,
                StringUtils.isBlank(errorMessage) ? HyResponse.ERROR_MESSAGE : errorMessage);
    }

    /**
     * 失败
     *
     * @param e
     * @param <T>
     * @return
     */
    public static <T> HyResponse<T> error(Exception e) {
        return new HyResponse<>(HyResponse.ERROR_CODE, e.toString());
    }

    /**
     * 成功
     *
     * @param <T>
     * @return
     */
    public static <T> HyResponse<T> ok() {
        return new HyResponse<>();
    }

    /**
     * 成功
     *
     * @param o
     * @param <T>
     * @return
     */
    public static <T> HyResponse<T> ok(T o) {
        return new HyResponse<>(HyResponse.SUCCESS_CODE, HyResponse.SUCCESS_MESSAGE, o);
    }
}
