package com.grandvauxc.companyutility.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public abstract class AbstractContactDto extends AbstractDto{
    private String email;

    private String address;

    @Length(max = 5, min = 5, message = "Zip code contains 5 character")
    private String zipCode;

    private String city;

    private String contactFirstName;

    private String contactLastName;

    @Length(min = 14, max = 14, message = "SIRET number must have 14 number")
    private String numSiret;

    private String socialReason;

    private String phoneNumber;

    private String tvaNumber;
}
