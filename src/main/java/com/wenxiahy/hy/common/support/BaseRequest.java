package com.wenxiahy.hy.common.support;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-15
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseRequest implements Serializable {

}
