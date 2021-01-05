package com.max.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NeedCategoryValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedCategory {
    String message() default "Need category!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
