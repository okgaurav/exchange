package com.exchange.service;

public class ServiceConstants {
    public static final String BASE_URL = "https://api.coindesk.com";
    public static final String COINS_DATA = "/v1/bpi/historical/close.json";
    public static final String API_KEY = "b86e21d491b21662dd8ca134";
    public static final String CURRENCY_BASE_URL = "https://v6.exchangerate-api.com/v6/";
    public static final String CURRENCY_URL_PREFIX = CURRENCY_BASE_URL+ API_KEY+"/latest/";
    public static final String USD = "USD";

    public static final String CACHE_KEY = "671a52633c0d8e09973f3470";
    public static final String EXCHANGE_CACHE_KEY = "671a5617a304ec67b1c278cc";

    public static final String CONFIG_CONSTANT = "crypto";

    public static final String ERROR_MESSAGE_ON_CACHE_FAILURE = "Unable to fetch data from API and no cached data is available.";
}
