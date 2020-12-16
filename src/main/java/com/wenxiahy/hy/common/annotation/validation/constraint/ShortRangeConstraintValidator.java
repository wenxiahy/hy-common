package com.wenxiahy.hy.common.annotation.validation.constraint;

import com.wenxiahy.hy.common.annotation.validation.ShortRange;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-15
 */
public class ShortRangeConstraintValidator implements ConstraintValidator<ShortRange, Short> {

    private short[] ranges;

    @Override
    public boolean isValid(Short value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }

        if (ranges == null || ranges.length == 0) {
            return true;
        }

        for (short s : ranges) {
            if (value.shortValue() == s) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void initialize(ShortRange constraintAnnotation) {
        ranges = constraintAnnotation.value();
    }
}
