package com.wenxiahy.hy.common.support.interceptor;

import com.wenxiahy.hy.common.bean.auth.AuthenticationUser;
import com.wenxiahy.hy.common.util.Base64Utils;
import com.wenxiahy.hy.common.util.HyStringUtils;
import com.wenxiahy.hy.common.util.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author zhouw
 * @Description 为下游服务添加requestAttribute
 * @Date 2020-12-22
 */
public class AuthUserRequestInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthUserRequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String xor = request.getHeader("X-Auth-User");
        if (xor == null) {
            return true;
        }

        try {
            String base64Str = HyStringUtils.xorEncry(xor);
            String authUserJson = Base64Utils.decryptNormalBase64(base64Str);
            AuthenticationUser authUser = JacksonUtils.json2Object(authUserJson, AuthenticationUser.class);
            if (authUser != null) {
                request.setAttribute("auth_user", authUser);
            }
        } catch (Exception e) {
            LOGGER.error("解析AuthenticationUser发生异常：{}", e.getMessage());
            e.printStackTrace();
        }

        return true;
    }
}
