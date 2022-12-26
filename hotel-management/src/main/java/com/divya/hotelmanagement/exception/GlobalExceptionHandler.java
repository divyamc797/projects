package com.divya.hotelmanagement.exception;

import com.divya.hotelmanagement.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@org.springframework.web.bind.annotation.ControllerAdvice
public class GlobalExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ErrorDTO> handleNoDataFoundException(NoDataFoundException ex,
                                                               WebRequest webRequest) {
        ErrorDTO errorDTO = ErrorDTO
                .builder()
                .timestamp(LocalDateTime.now())
                .details(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
