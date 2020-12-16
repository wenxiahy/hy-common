package com.wenxiahy.hy.common.support;

import com.wenxiahy.hy.common.util.JacksonUtils;

import java.io.Serializable;

/**
 * @Author zhouw
 * @Description 统一接口响应封装
 * @Date 2020-12-15
 */
public class HyResponse<T> implements Serializable {

    public static final int SUCCESS_CODE = 0;
    public static final String SUCCESS_MESSAGE = "success";

    public static final int ERROR_CODE = -1;
    public static final String ERROR_MESSAGE = "系统错误";

    public static final int NO_DATA_CODE = 1;
    public static final String NO_DATA_MESSAGE = "查无数据";

    public static final int ERROR_ARGUMENT_CODE = 2;
    public static final String ERROR_ARGUMENT_MESSAGE = "参数错误";

    // 需要登录
    public static final int NO_ACCESS_CODE = 3;
    public static final String NO_ACCESS_MESSAGE = "无权访问";

    private int code;
    private String message;
    private T result;

    HyResponse(int code, String message, T result) {
        super();
        this.code = code;
        this.message = message;
        this.result = result;
    }

    HyResponse(int code, String message) {
        this(code, message, null);
    }

    HyResponse() {
        this(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return JacksonUtils.object2Json(this);
    }
}
