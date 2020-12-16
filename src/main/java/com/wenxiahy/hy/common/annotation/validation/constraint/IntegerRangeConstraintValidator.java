package com.wenxiahy.hy.common.annotation.validation.constraint;

import com.wenxiahy.hy.common.annotation.validation.IntegerRange;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-15
 */
public class IntegerRangeConstraintValidator implements ConstraintValidator<IntegerRange, Integer> {

    private int[] ranges;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }

        if (ranges == null || ranges.length == 0) {
            return true;
        }

        for (int i : ranges) {
            if (value.intValue() == i) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void initialize(IntegerRange constraintAnnotation) {
        ranges = constraintAnnotation.value();
    }
}
