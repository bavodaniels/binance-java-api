package be.bavodaniels.binance.api.endpoints.general;

import be.bavodaniels.binance.api.endpoints.general.model.ExchangeInfo;
import be.bavodaniels.binance.api.endpoints.general.model.Time;
import feign.RequestLine;

public interface GeneralEndpoint {
    @RequestLine("GET /api/v3/ping")
    void ping();

    @RequestLine("GET /api/v3/time")
    Time getTime();

    @RequestLine("GET /api/v3/exchangeInfo")
    ExchangeInfo getExchangeInfo();
}
