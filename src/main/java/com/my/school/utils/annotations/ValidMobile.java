package com.my.school.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = MobileValidator.class)
@Documented
public @interface ValidMobile {

    String message() default "{STUD_ERR.BAD_MOB}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
