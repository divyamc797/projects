package com.divya.currencyconverter.service;

import com.divya.currencyconverter.dto.CurrencyConverterDTO;
import com.divya.currencyconverter.entity.CurrencyConverterEntity;
import com.divya.currencyconverter.repository.CurrencyConverterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyConverterServiceImpl implements CurrencyConverterService {

    @Autowired
    private CurrencyConverterRepository currencyConverterRepository;

    @Override
    public CurrencyConverterDTO getCurrencyConvertedValue(CurrencyConverterDTO currencyConverterDTO) {
        CurrencyConverterEntity currencyConverterRateByCurrencyFromAndCurrencyTo =
                currencyConverterRepository.findCurrencyConverterEntityByCurrencyFromAndCurrencyTo(currencyConverterDTO.getCurrencyFrom(), currencyConverterDTO.getCurrencyTo());
//        int convertedValue = BigDecimal.valueOf(currencyConverterRateByCurrencyFromAndCurrencyTo).multiply(currencyConverterDTO.getCurrencyToBeConvertedValue());
        int convertedValue = currencyConverterRateByCurrencyFromAndCurrencyTo.getCurrencyRate() * currencyConverterDTO.getCurrencyToBeConvertedValue();
        currencyConverterDTO.setTotal(convertedValue);
        return currencyConverterDTO;
    }
}
