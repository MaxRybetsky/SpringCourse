package com.max.validation;

import com.max.entity.Category;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NeedCategoryValidator implements ConstraintValidator<NeedCategory, Category> {

    @Override
    public boolean isValid(Category category, ConstraintValidatorContext constraintValidatorContext) {
        return category != null;
    }
}
