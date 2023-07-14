package com.grandvauxc.companyutility.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.UUID;

@Data
public class CustomerDto implements Serializable {
    private final UUID id;
    private final String email;
    private final String address;
    @Length(max = 5, min = 5, message = "Zip code contains 5 character")
    private final String zipCode;
    private final String City;
    private final String contactFirstName;
    private final String contactLastName;
    @Length(min = 14, max = 14, message = "SIRET number must have 14 number")
    private final String numSiret;
    private final String socialReason;
    private final String phoneNumber;
    private final String tvaNumber;
}
