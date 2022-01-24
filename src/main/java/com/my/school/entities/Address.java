package com.my.school.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.my.school.utils.annotations.ValidPin;
import com.my.school.utils.errors.Err;

import lombok.Data;

@Embeddable
@Data
public class Address {

    @NotBlank(message = Err.ADDR_NO_L1)
    private String addrLine1;

    private String addrLine2;

    @NotBlank(message = Err.ADDR_NO_CITY)
    private String city;

    @NotNull(message = Err.ADDR_NO_PIN)
    @ValidPin
    private String pin;

    @NotBlank(message = Err.ADDR_NO_STATE)
    private String state;

    @NotBlank(message = Err.ADDR_NO_COUNTRY)
    private String country;
}
