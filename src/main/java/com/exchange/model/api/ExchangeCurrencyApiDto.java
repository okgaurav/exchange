package com.exchange.model.api;

import java.util.List;

public class ExchangeCurrencyApiDto {
    private String currency;
    private List<Number> amount;

    public String getCurrency() {
        return currency;
    }

    public ExchangeCurrencyApiDto setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public List<Number> getAmount() {
        return amount;
    }

    public ExchangeCurrencyApiDto setAmount(List<Number> amount) {
        this.amount = amount;
        return this;
    }
}
