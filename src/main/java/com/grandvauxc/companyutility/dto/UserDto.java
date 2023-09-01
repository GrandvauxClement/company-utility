package com.grandvauxc.companyutility.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UserDto extends AbstractDto {

    private String email;

    private UUID keycloakId;
}
