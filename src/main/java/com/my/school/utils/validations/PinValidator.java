package com.my.school.utils.validations;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.my.school.utils.annotations.ValidPin;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PinValidator implements ConstraintValidator<ValidPin, String> {

    @Override
    public boolean isValid(String pin, ConstraintValidatorContext context) {
        String pinRegex = "^\\d{6}$";

        if (pin == null) {
            log.error("pin is null");
            return false;
        } else if ((Pattern.compile(pinRegex).matcher(pin).matches())) {
            return true;
        } else
            return false;
    }

}
