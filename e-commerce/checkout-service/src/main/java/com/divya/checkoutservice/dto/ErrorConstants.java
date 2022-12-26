package com.divya.checkoutservice.dto;

import lombok.Getter;

@Getter
public enum ErrorConstants {
    ORDER_NOT_FOUND(1111, "Error not exist in DB", 404);

    ErrorConstants(int code, String details, int httpStatusCode) {
        this.code = code;
        this.details = details;
        this.httpStatusCode = httpStatusCode;
    }

    private int code;
    private String details;
    private int httpStatusCode;
}
