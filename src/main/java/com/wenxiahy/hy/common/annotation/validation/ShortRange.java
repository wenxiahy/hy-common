package com.wenxiahy.hy.common.annotation.validation;

import com.wenxiahy.hy.common.annotation.validation.constraint.ShortRangeConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-15
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ShortRangeConstraintValidator.class)
public @interface ShortRange {

    String message() default "参数值不在限定范围里面";

    short[] value();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
