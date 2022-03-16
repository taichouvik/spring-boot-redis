package com.my.school.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.my.school.constants.ErrorConstants;
import com.my.school.validations.impl.ValidPinImpl;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ValidPinImpl.class)
@Documented
public @interface ValidPin {

    String message() default ErrorConstants.ADDR_BAD_PIN;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
