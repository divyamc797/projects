package com.divya.currencyconverter.repository;

import com.divya.currencyconverter.entity.CurrencyConverterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CurrencyConverterRepository extends JpaRepository<CurrencyConverterEntity, Integer> {

    CurrencyConverterEntity findCurrencyConverterEntityByCurrencyFromAndCurrencyTo(String currencyFrom, String currencyTo);
}
