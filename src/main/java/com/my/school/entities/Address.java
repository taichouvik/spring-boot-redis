package com.my.school.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.my.school.constants.ErrorConstants;
import com.my.school.validations.ValidPin;

import lombok.Data;

@Embeddable
@Data
public class Address {

    @NotBlank(message = ErrorConstants.ADDR_NO_L1)
    private String addrLine1;

    private String addrLine2;

    @NotBlank(message = ErrorConstants.ADDR_NO_CITY)
    private String city;

    @NotNull(message = ErrorConstants.ADDR_NO_PIN)
    @ValidPin
    private String pin;

    @NotBlank(message = ErrorConstants.ADDR_NO_STATE)
    private String state;

    @NotBlank(message = ErrorConstants.ADDR_NO_COUNTRY)
    private String country;
}
