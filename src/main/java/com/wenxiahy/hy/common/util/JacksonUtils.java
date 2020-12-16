package com.wenxiahy.hy.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-15
 */
public class JacksonUtils {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // 时间格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        // null不处理
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // 反序列化时，忽略未知字段
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 允许出现特殊字符和转义符
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

        // 单引号处理
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }

    public static <T> String object2Json(T object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T json2Object(String json, Class<T> c) {
        try {
            return objectMapper.readValue(json, c);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

