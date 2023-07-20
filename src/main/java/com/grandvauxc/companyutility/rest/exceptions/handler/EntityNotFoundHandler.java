package com.grandvauxc.companyutility.rest.exceptions.handler;

import com.grandvauxc.companyutility.exceptions.EntityNotFoundException;
import com.grandvauxc.companyutility.rest.exceptions.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class EntityNotFoundHandler extends ExceptionHandlerResource {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ResponseEntity<ErrorResponse> entityNotFoundException(EntityNotFoundException ex, WebRequest request){
        return generateResponseEntity(ex, request, HttpStatus.NOT_FOUND);
    }
}
