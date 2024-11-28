package com.exchange.model.entity;

import java.util.List;

public class Exchange {
    private String currency;
    private List<Number> amount;

    public String getCurrency() {
        return currency;
    }

    public Exchange setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public List<Number> getAmount() {
        return amount;
    }

    public Exchange setAmount(List<Number> amount) {
        this.amount = amount;
        return this;
    }
}
