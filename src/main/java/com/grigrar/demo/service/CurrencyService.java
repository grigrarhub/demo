package com.grigrar.demo.service;

import com.grigrar.demo.model.Currency;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CurrencyService {
    public BigDecimal conversionCurrency(BigDecimal currency1, BigDecimal currency2,
                                         BigDecimal money);
    public List<Currency> getCurs();
}
