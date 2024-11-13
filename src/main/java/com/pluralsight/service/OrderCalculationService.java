package com.pluralsight.service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Calculates cost of an order and displays it in USD format.
 */
public class OrderCalculationService {
    private NumberFormat usdFormat = NumberFormat.getCurrencyInstance(Locale.US);

    public String convertToUSDString(BigDecimal value){
        return usdFormat.format(value);
    }
}
