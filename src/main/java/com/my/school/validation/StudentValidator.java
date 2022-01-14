package com.my.school.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.my.school.entity.Address;
import com.my.school.entity.Student;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class StudentValidator implements ConstraintValidator<ValidStudent, Student> {

    @Override
    public boolean isValid(Student value, ConstraintValidatorContext context) {

        if (!(value instanceof Student))
            return false;

        if (value.getId() == 0
                || value.getEmail() == null
                || value.getName() == null
                || value.getAddress() == null)
            return false;
        
        log.info("chking email");

        String emailRegex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        if (!(Pattern.compile(emailRegex).matcher(value.getEmail()).matches()))
            return false;

        log.info("chking mob");

        String mobRegex = "^\\d{10}$";
        if (!(Pattern.compile(mobRegex).matcher(value.getMob()).matches()))
            return false;

        log.info("checkin addr");
        Address addr = value.getAddress();
        if (addr.getAddrLine1() == null
                || addr.getCountry() == null
                || addr.getState() == null
                || addr.getPin() == null)
            return false;

        log.info("Chking pin");
        String pinRegex = "^\\d{6}$";
        if (!(Pattern.compile(pinRegex).matcher(addr.getPin()).matches()))
            return false;

        return true;
    }

}
