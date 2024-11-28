package com.exchange.controller;

import com.exchange.model.api.ExchangeCurrencyApiDto;
import com.exchange.model.entity.Crypto;
import com.exchange.model.entity.ExchangeCurrency;
import com.exchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static com.exchange.controller.ExchangeConstants.*;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(COIN_CONTROLLER_PATH)
public class ExchangeController {


    @Autowired
    ExchangeService exchangeService;


    @GetMapping(GET_COIN_PATH)
    public  ResponseEntity<Mono<ExchangeCurrency>> getDummyData() {
        return new ResponseEntity<>(exchangeService.getExchangeRate(), OK);
    }

    @GetMapping((GET_PROFILE_DATA))
    public ResponseEntity<Mono<Crypto>> getApplicationProfileDate() {
        return new ResponseEntity<>(exchangeService.fetchProfileDetails(), OK);
    }

    @PostMapping(GET_COIN_PATH)
    public ResponseEntity<Mono<ExchangeCurrencyApiDto>> getExchange(@RequestBody ExchangeCurrencyApiDto currencyApiDto){
        return new ResponseEntity<>(exchangeService.calculateExchangeRate(currencyApiDto), OK);
    }

}
