package com.wenxiahy.hy.common.annotation.validation.constraint;

import com.wenxiahy.hy.common.annotation.validation.Phone;
import com.wenxiahy.hy.common.util.HyStringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-15
 */
public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return HyStringUtils.isPhone(value);
    }

    @Override
    public void initialize(Phone constraintAnnotation) {

    }
}
