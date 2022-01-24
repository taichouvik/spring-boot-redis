package com.my.school.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.my.school.utils.annotations.ValidPin;

import lombok.Data;

@Embeddable
@Data
public class Address {

    @NotBlank(message = "{addr.err.no.addrl1}")
    private String addrLine1;

    private String addrLine2;

    @NotBlank(message = "{addr.err.no.city}")
    private String city;

    @NotNull(message = "{addr.err.no.pin}")
    @ValidPin
    private String pin;

    @NotBlank(message = "{addr.err.no.state}")
    private String state;

    @NotBlank(message = "{addr.err.no.country}")
    private String country;
}
