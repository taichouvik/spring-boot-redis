package com.my.school.utils.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.my.school.utils.errors.Err;
import com.my.school.utils.validations.MobileValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = MobileValidator.class)
@Documented
public @interface ValidMobile {

    String message() default Err.STUD_BAD_MOB;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
