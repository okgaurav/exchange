package com.exchange.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class ExchangeCurrency {
    @JsonProperty("conversion_rates")
    Map<String, Number> conversionRates;

    @JsonProperty("base_code")
    String baseCurrencyCode;

    public Map<String, Number> getConversionRates() {
        return conversionRates;
    }

    public ExchangeCurrency setConversionRates(Map<String, Number> conversionRates) {
        this.conversionRates = conversionRates;
        return this;
    }

    public String getBaseCurrencyCode() {
        return baseCurrencyCode;
    }

    public ExchangeCurrency setBaseCurrencyCode(String baseCurrencyCode) {
        this.baseCurrencyCode = baseCurrencyCode;
        return this;
    }
}
