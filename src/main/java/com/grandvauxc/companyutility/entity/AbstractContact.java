package com.grandvauxc.companyutility.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString
public class AbstractContact extends AbstractEntity{

    @Column(unique = true, nullable = false, name = "email")
    @Email
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "zip_code")
    @Length(max = 5, min = 5, message = "Zip code contains 5 character")
    private String zipCode;

    @Column(name = "city")
    private String city;

    @Column(name = "contact_first_name")
    private String contactFirstName;

    @Column(name = "contact_last_name")
    private String contactLastName;

    @Column(unique = true, nullable = false, name = "num_siret")
    @Length(min = 14, max = 14, message = "SIRET number must have 14 number")
    private String numSiret;

    @Column(name = "social_reason")
    private String socialReason;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "tva_number")
    private String tvaNumber;
}
