package be.bavodaniels.binance.api.endpoints.marketdata;

import be.bavodaniels.binance.api.endpoints.marketdata.model.OrderBook;
import be.bavodaniels.binance.api.endpoints.marketdata.model.OrderBookLimit;
import be.bavodaniels.binance.api.endpoints.marketdata.model.OrderBookLimit.OrderBookLimitExpander;
import be.bavodaniels.binance.api.endpoints.marketdata.model.RecentTrade;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface MarketDataEndpoint {
    @RequestLine("GET /api/v3/depth?symbol={symbol}")
    OrderBook getOrderbook(@Param("symbol") String symbol);

    @RequestLine("GET /api/v3/depth?symbol={symbol}&limit={limit}")
    OrderBook getOrderbook(@Param("symbol") String symbol,
                           @Param(value = "limit", expander = OrderBookLimitExpander.class) OrderBookLimit limit);

    @RequestLine("GET /api/v3/trades?symbol={symbol}")
    List<RecentTrade> getRecentTrades(@Param("symbol") String symbol);

    @RequestLine("GET /api/v3/trades?symbol={symbol}&limit={limit}")
    List<RecentTrade> getRecentTrades(@Param("symbol") String symbol,
                                      @Param("limit") Integer limit);


    @Headers("X-MBX-APIKEY: {apiKey}")
    @RequestLine("GET /api/v3/historicalTrades?symbol={symbol}")
    List<RecentTrade> getHistoricalTrades(@Param("symbol") String symbol,
                                          @Param("apiKey") String apiKey);

    @Headers("X-MBX-APIKEY: {apiKey}")
    @RequestLine("GET /api/v3/historicalTrades?symbol={symbol}&limit={limit}&fromId={fromId}")
    List<RecentTrade> getHistoricalTrades(@Param("symbol") String symbol,
                                      @Param("limit") Integer limit,
                                      @Param("fromId") Long fromId,
                                          @Param("apiKey") String apiKey);

    @Headers("X-MBX-APIKEY: {apiKey}")
    @RequestLine("GET /api/v3/historicalTrades?symbol={symbol}&limit={limit}")
    List<RecentTrade> getHistoricalTrades(@Param("symbol") String symbol,
                                          @Param("limit") Integer limit,
                                          @Param("apiKey") String apiKey);

    @Headers("X-MBX-APIKEY: {apiKey}")
    @RequestLine("GET /api/v3/historicalTrades?symbol={symbol}&fromId={fromId}")
    List<RecentTrade> getHistoricalTrades(@Param("symbol") String symbol,
                                          @Param("fromId") Long fromId,
                                          @Param("apiKey") String apiKey);
}
