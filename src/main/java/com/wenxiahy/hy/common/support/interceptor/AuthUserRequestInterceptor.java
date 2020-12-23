package com.wenxiahy.hy.common.support.interceptor;

import com.wenxiahy.hy.common.bean.auth.AuthenticationUser;
import com.wenxiahy.hy.common.util.JacksonUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author zhouw
 * @Description 为下游服务添加requestAttribute
 * @Date 2020-12-22
 */
public class AuthUserRequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authUserJson = request.getHeader("X-Auth-User");
        AuthenticationUser authUser = JacksonUtils.json2Object(authUserJson, AuthenticationUser.class);
        if (authUser != null) {
            request.setAttribute("auth_user", authUser);
        }

        return true;
    }
}
