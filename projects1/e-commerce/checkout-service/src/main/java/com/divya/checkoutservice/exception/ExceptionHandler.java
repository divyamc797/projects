package com.divya.checkoutservice.exception;

import com.divya.checkoutservice.dto.ErrorConstants;
import com.divya.checkoutservice.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ErrorDTO> handleNoDataFoundException(NoDataFoundException noDataFoundException,
                                                               WebRequest webRequest) {
        ErrorDTO errorDTO = ErrorDTO
                .builder()
                .details(noDataFoundException.getMessage())
                .errorCode(ErrorConstants.ORDER_NOT_FOUND.getCode())
                .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
