package com.pluralsight.service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Formats a BigDecimal value into a USD format.
 */
public class OrderCalculationService {
    private NumberFormat usdFormat = NumberFormat.getCurrencyInstance(Locale.US);

    public String convertToUSDString(BigDecimal value){
        return usdFormat.format(value);
    }
}
