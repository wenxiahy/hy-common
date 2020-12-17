package com.wenxiahy.hy.common.support.aspect;

import com.wenxiahy.hy.common.exception.ErrorArgumentException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhouw
 * @Description
 * @Date 2019-12-05
 */
@Component
@Aspect
@Order(2)
public class RequestValidatorAspect {

    @Pointcut(
            "execution(public com.wenxiahy.hy.common.support.HyResponse com.wenxiahy.hy.*.controller.*Controller.*(..,org.springframework.validation.BindingResult))"
    )
    public void validatePointcut() {

    }

    @Before("validatePointcut() && args(..,bindingResult)")
    public void validateAdvice(JoinPoint point, BindingResult bindingResult) {
        List<String> errors = getErrors(bindingResult);
        if (errors != null && errors.size() > 0) {
            StringBuilder sb = new StringBuilder(errors.get(0));
            if (errors.size() > 1) {
                for (int i = 1; i < errors.size(); i++) {
                    sb.append("，");
                    sb.append(errors.get(i));
                }
            }

            throw new ErrorArgumentException(sb.toString());
        }
    }

    private List<String> getErrors(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
        }

        return null;
    }
}
