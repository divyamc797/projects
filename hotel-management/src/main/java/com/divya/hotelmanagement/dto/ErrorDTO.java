package com.divya.hotelmanagement.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorDTO {
    private LocalDateTime timestamp;
    private String details;
}
