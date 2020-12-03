package com.grigrar.demo.service.impl;

import com.grigrar.demo.model.Currency;
import com.grigrar.demo.repository.CurrencyRepository;
import com.grigrar.demo.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;


    @Override
    public BigDecimal conversionCurrency(BigDecimal currency1, BigDecimal currency2, BigDecimal money) {
        return currency1.multiply(money).divide(currency2,4);
    }

    @Override
    public List<Currency> getCurs() {
        return currencyRepository.findAll();
    }
}
