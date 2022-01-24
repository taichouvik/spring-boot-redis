package com.my.school.utils.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.my.school.utils.errors.Err;
import com.my.school.utils.validations.PinValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PinValidator.class)
@Documented
public @interface ValidPin {

    String message() default Err.ADDR_BAD_PIN;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
