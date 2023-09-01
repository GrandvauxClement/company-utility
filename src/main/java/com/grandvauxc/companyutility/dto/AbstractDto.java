package com.grandvauxc.companyutility.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@NoArgsConstructor
public abstract class AbstractDto {

    @Schema(description = "Id", example = "<UUID>")
    private String id;
}
