package com.exchange.service;

import com.exchange.mapper.ExchangeMapper;
import com.exchange.model.api.ExchangeCurrencyApiDto;
import com.exchange.model.entity.Crypto;
import com.exchange.model.entity.Exchange;
import com.exchange.model.entity.ExchangeCurrency;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.exchange.mapper.ExchangeMapper.toEntity;
import static com.exchange.service.ServiceConstants.CURRENCY_URL_PREFIX;
import static com.exchange.service.ServiceConstants.ERROR_MESSAGE_ON_CACHE_FAILURE;
import static com.exchange.service.ServiceConstants.EXCHANGE_CACHE_KEY;
import static com.exchange.service.ServiceConstants.USD;

@Service
public class ExchangeService {
    private final WebClient webClient;
    private final ProfileDetails profileDetails;
    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeService.class);
    private final Cache<String, ExchangeCurrency> cache;

    public ExchangeService(WebClient.Builder webClient, ProfileDetails profileDetails) {
        this.webClient = webClient.baseUrl(CURRENCY_URL_PREFIX).build();
        this.profileDetails = profileDetails;
        this.cache = Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.HOURS).maximumSize(100).build();
    }

    public Mono<ExchangeCurrency> getExchangeRate() {
        LOGGER.info("Fetching exchange-rate data");
        ExchangeCurrency currencyCache = cache.getIfPresent(EXCHANGE_CACHE_KEY);
        if (currencyCache != null) {
            LOGGER.info("Fetching data from cache, Reducing one Call to Exchange Api");
            return Mono.just(currencyCache);
        }
        return webClient.get()
                .uri(USD)
                .retrieve()
                .bodyToMono(ExchangeCurrency.class)
                .doOnNext(data -> cache.put(EXCHANGE_CACHE_KEY, data))
                .onErrorResume(error -> Mono.error(new RuntimeException(ERROR_MESSAGE_ON_CACHE_FAILURE)));
    }
    private Mono<List<Number>> convertBigDecimalToNumber(List<BigDecimal> bigDecimals) {
        return Flux.fromIterable(bigDecimals)
                .map(bigDecimal -> (Number) bigDecimal)
                .collectList();
    }

    public Mono<ExchangeCurrencyApiDto> calculateExchangeRate(String correlationId, ExchangeCurrencyApiDto exchangeApi) {
        LOGGER.debug("crypto correlationId found in exchange: {}", correlationId);
        var exchange = toEntity(exchangeApi);
        return getExchangeRate()
                .filter(a -> a.getConversionRates().containsKey(exchange.getCurrency()))
                .map(a-> exchange.getAmount().stream().map(amt-> BigDecimal.valueOf(a.getConversionRates().get(exchange.getCurrency()).doubleValue()).multiply(BigDecimal.valueOf(amt.doubleValue()))).toList())
                .flatMap(this:: convertBigDecimalToNumber)
                .map(exchange::setAmount)
                .map(ExchangeMapper::toApi);
    }

    public Mono<Crypto> fetchProfileDetails(){
        return Mono.just(new Crypto().setContactDetails(profileDetails.getContactDetails()).setMessage(profileDetails.getMessage()));
    }

}
