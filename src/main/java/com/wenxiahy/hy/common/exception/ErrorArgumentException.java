package com.wenxiahy.hy.common.exception;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-15
 */
public class ErrorArgumentException extends RuntimeException {

    private String message;

    public ErrorArgumentException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
