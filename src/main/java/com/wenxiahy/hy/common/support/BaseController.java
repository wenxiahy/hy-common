package com.wenxiahy.hy.common.support;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-15
 */
public class BaseController {

    protected <T> HyResponse<T> ok(T data) {
        return ResponseMapper.ok(data);
    }

    protected <T> HyResponse<T> ok() {
        return ResponseMapper.ok();
    }

    protected <T> HyResponse<T> error() {
        return ResponseMapper.error();
    }

    protected <T> HyResponse<T> error(String errorMessage) {
        return ResponseMapper.error(errorMessage);
    }

    protected <T> HyResponse<T> error(Exception e) {
        return ResponseMapper.error(e);
    }

    protected <T> HyResponse<T> noData() {
        return ResponseMapper.noData();
    }

    protected <T> HyResponse<T> noAccess() {
        return ResponseMapper.noAccess();
    }

    protected <T> HyResponse<T> errorArgument() {
        return ResponseMapper.errorArgument();
    }

    protected <T> HyResponse<T> errorArgument(String errorMessage) {
        return ResponseMapper.errorArgument(errorMessage);
    }
}
