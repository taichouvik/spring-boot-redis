package com.my.school.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.my.school.constants.ErrorConstants;
import com.my.school.validations.impl.ValidMobileImpl;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ValidMobileImpl.class)
@Documented
public @interface ValidMobile {

    String message() default ErrorConstants.STUD_BAD_MOB;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
