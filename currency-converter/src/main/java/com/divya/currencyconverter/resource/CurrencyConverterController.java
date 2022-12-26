package com.divya.currencyconverter.resource;

import com.divya.currencyconverter.dto.CurrencyConverterDTO;
import com.divya.currencyconverter.service.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-converter")
public class CurrencyConverterController {

    @Autowired
    private CurrencyConverterService currencyConverterService;

    @PostMapping()
    public ResponseEntity<?> getConversionValue(@RequestBody CurrencyConverterDTO currencyConverterDTO) {
        CurrencyConverterDTO currencyConvertedValue =
                currencyConverterService.getCurrencyConvertedValue(currencyConverterDTO);
        return ResponseEntity.ok().body(currencyConvertedValue);
    }
}
