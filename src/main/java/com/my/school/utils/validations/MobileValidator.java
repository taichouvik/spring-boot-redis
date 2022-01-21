package com.my.school.validations;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MobileValidator implements ConstraintValidator<ValidMobile, String> {

    @Override
    public boolean isValid(String mob, ConstraintValidatorContext context) {
        String mobRegex = "^\\d{10}$";

        if (mob == null) {
            log.error("mob is null");
            return false;
        } else if ((Pattern.compile(mobRegex).matcher(mob).matches())) {
            return true;
        } else
            return false;
    }

}
