package com.divya.checkoutservice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorDTO {
    public String details;
    public int errorCode;
}
