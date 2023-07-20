package com.grandvauxc.companyutility.rest.exceptions.handler;

import com.grandvauxc.companyutility.rest.exceptions.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.UUID;

@Slf4j
public abstract class ExceptionHandlerResource extends ResponseEntityExceptionHandler {

    public ResponseEntity<ErrorResponse> generateResponseEntity(RuntimeException ex, WebRequest request, HttpStatus httpStatus){
        String errorId = UUID.randomUUID().toString();

        if(doLogError()){
            log.error("ERROR, exception classe : {}\n" +
                    "error id : {}\n" +
                    "exception info : ",
                    ex.getClass(),
                    errorId,
                    ex
            );
        }

        ErrorResponse errorResponse = new ErrorResponse(
                errorId,
                httpStatus.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    protected boolean doLogError(){
        return true;
    }
}
