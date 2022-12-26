package com.divya.currencyconverter.service;

import com.divya.currencyconverter.dto.CurrencyConverterDTO;

import java.math.BigDecimal;

public interface CurrencyConverterService {
    CurrencyConverterDTO getCurrencyConvertedValue(CurrencyConverterDTO currencyConverterDTO);
}
