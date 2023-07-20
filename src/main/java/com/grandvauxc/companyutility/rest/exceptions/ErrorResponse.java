package com.grandvauxc.companyutility.rest.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String errorId;
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
}
