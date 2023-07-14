package com.grandvauxc.companyutility.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class UserDto implements Serializable {
    private final UUID id;
    private final String email;
    private final UUID keycloakId;
}
