package com.target.spring.products.model;

import com.target.spring.products.resources.CurrencyCodes;

import java.math.BigDecimal;

public class ProductPrice {
    private BigDecimal value;
    private String currencyCode;

    public ProductPrice(final BigDecimal value, final String currencyCode){
        this.value = value;
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getCurrencyValue() {
        return value;
    }

    public void setCurrencyValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "value=" + value +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
