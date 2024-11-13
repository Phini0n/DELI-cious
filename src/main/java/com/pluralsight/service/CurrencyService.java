package com.pluralsight.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyService {
    private NumberFormat usdFormat = NumberFormat.getCurrencyInstance(Locale.US);

    public String convertToUSDString(BigDecimal value){
        return usdFormat.format(value);
    }
}
