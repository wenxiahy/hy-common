package com.wenxiahy.hy.common.support;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-15
 */
public abstract class BasePagedRequest extends BaseRequest {

    @JsonProperty("page_num")
    private int pageNum;

    public int getPageNum() {
        return pageNum < 1 ? 1 : pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
