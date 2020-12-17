package com.wenxiahy.hy.common.support.aspect;

import com.wenxiahy.hy.common.exception.ErrorArgumentException;
import com.wenxiahy.hy.common.support.ResponseMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author zhouw
 * @Description
 * @Date 2019-12-05
 */
@Component
@Aspect
@Order(1)
public class GlobalExceptionAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionAspect.class);

    @Pointcut(
            "execution(public com.wenxiahy.hy.common.support.HyResponse com.wenxiahy.hy.*.controller.*Controller.*(..))"
    )
    public void exceptionPointcut() {

    }

    @Around("exceptionPointcut()")
    public Object exceptionAdvice(ProceedingJoinPoint point) {
        String className = point.getTarget().getClass().getName();
        String method = point.getSignature().getName();
        try {
            return point.proceed();
        } catch (Throwable t) {
            if (t instanceof ErrorArgumentException) {
                return ResponseMapper.errorArgument(t.getMessage());
            } else {
                LOGGER.error("Class：{}，Method：{}发生异常：{}", className, method, t.getMessage());
                t.printStackTrace();

                return ResponseMapper.error(t.toString());
            }
        }
    }
}
