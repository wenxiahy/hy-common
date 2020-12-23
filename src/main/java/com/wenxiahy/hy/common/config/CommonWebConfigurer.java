package com.wenxiahy.hy.common.config;

import com.wenxiahy.hy.common.support.interceptor.AuthUserRequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-22
 */
@Configuration
public class CommonWebConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthUserRequestInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/auth/**");
    }
}
