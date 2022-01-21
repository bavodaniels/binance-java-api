package be.bavodaniels.binance.api.endpoints.marketdata;

import be.bavodaniels.binance.api.endpoints.marketdata.model.OrderBook;
import be.bavodaniels.binance.api.endpoints.marketdata.model.OrderBookLimit;
import be.bavodaniels.binance.api.endpoints.marketdata.model.OrderBookLimit.OrderBookLimitExpander;
import be.bavodaniels.binance.api.endpoints.marketdata.model.RecentTrade;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface MarketDataEndpoint {
    @RequestLine("GET /api/v3/depth?symbol={symbol}&limit={limit}")
    OrderBook getOrderbook(@Param("symbol") String symbol,
                           @Param(value = "limit", expander = OrderBookLimitExpander.class) OrderBookLimit limit);

    @RequestLine("GET /api/v3/trades?symbol={symbol}&limit={limit}")
    List<RecentTrade> getRecentTrades(@Param("symbol") String symbol,
                                      @Param(value = "limit") Integer limit);
}
