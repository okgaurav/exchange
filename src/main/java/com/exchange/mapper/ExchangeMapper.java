package com.exchange.mapper;

import com.exchange.model.api.ExchangeCurrencyApiDto;
import com.exchange.model.entity.Exchange;

public class ExchangeMapper {

    public static ExchangeCurrencyApiDto toApi(Exchange exchangeCurrency) {
        return new ExchangeCurrencyApiDto().setCurrency(exchangeCurrency.getCurrency())
                .setAmount(exchangeCurrency.getAmount());
    }

    public static Exchange toEntity(ExchangeCurrencyApiDto exchangeCurrencyApiDto) {
        return new Exchange().setAmount(exchangeCurrencyApiDto.getAmount())
                .setCurrency(exchangeCurrencyApiDto.getCurrency());
    }
}
