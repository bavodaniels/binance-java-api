package be.bavodaniels.binance.api.endpoints.marketdata;

import be.bavodaniels.binance.api.endpoints.marketdata.model.OrderBook;
import be.bavodaniels.binance.api.endpoints.marketdata.model.OrderBookLimit;
import be.bavodaniels.binance.api.endpoints.marketdata.model.OrderBookLimit.OrderBookLimitExpander;
import feign.Param;
import feign.RequestLine;

public interface MarketDataEndpoint {
    @RequestLine("GET /api/v3/depth?symbol={symbol}&limit={limit}")
    OrderBook orderbook(@Param("symbol") String symbol,
                        @Param(value = "limit", expander = OrderBookLimitExpander.class) OrderBookLimit limit);
}
