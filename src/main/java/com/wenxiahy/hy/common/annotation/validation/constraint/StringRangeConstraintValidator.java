package com.wenxiahy.hy.common.annotation.validation.constraint;

import com.wenxiahy.hy.common.annotation.validation.StringRange;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-15
 */
public class StringRangeConstraintValidator implements ConstraintValidator<StringRange, String> {

    private String[] ranges;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }

        if (ranges == null || ranges.length == 0) {
            return true;
        }

        for (String s : ranges) {
            if (value.equals(s)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void initialize(StringRange constraintAnnotation) {
        ranges = constraintAnnotation.value();
    }
}
