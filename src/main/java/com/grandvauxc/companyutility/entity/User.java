package com.grandvauxc.companyutility.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "\"user\"")
public class User extends AbstractEntity{

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "keycloak_id", nullable = false)
    private UUID keycloakId;
}
