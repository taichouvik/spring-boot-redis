package com.my.school.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = StudentValidator.class)
@Documented
public @interface ValidStudent {

    String message() default "student not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
