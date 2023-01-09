package com.divya.currencyconverter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConverterDTO {
    private String currencyFrom;
    private String currencyTo;
    private int currencyToBeConvertedValue;
    private int total;
}
