package be.bavodaniels.binance.api.endpoints.marketdata;

import be.bavodaniels.binance.api.endpoints.general.model.KLineInterval;
import be.bavodaniels.binance.api.endpoints.marketdata.model.*;
import be.bavodaniels.binance.api.endpoints.marketdata.model.OrderBookLimit.OrderBookLimitExpander;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.Date;
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

    @RequestLine("GET /api/v3/aggTrades?symbol={symbol}")
    List<AggregateTrade> getAggregateTrades(
            @Param("symbol") String symbol);

    @RequestLine("GET /api/v3/aggTrades?symbol={symbol}&fromId={fromId}")
    List<AggregateTrade> getAggregateTrades(@Param("symbol") String symbol,
                                            @Param("fromId") long fromId);

    @RequestLine("GET /api/v3/aggTrades?symbol={symbol}&startTime={startTime}&endTime={endTime}")
    List<AggregateTrade> getAggregateTrades(@Param("symbol") String symbol,
                                            @Param("startTime") Long startTime,
                                            @Param("endTime") Long endTime);

    @RequestLine("GET /api/v3/aggTrades?symbol={symbol}&limit={limit}")
    List<AggregateTrade> getAggregateTrades(@Param("symbol") String symbol,
                                            @Param("limit") int limit);

    @RequestLine("GET /api/v3/aggTrades?symbol={symbol}&fromId={fromId}&limit={limit}")
    List<AggregateTrade> getAggregateTrades(@Param("symbol") String symbol,
                                            @Param("fromId") long fromId,
                                            @Param("limit") int limit);

    @RequestLine("GET /api/v3/aggTrades?symbol={symbol}&startTime={startTime}&endTime={endTime}&limit={limit}")
    List<AggregateTrade> getAggregateTrades(@Param("symbol") String symbol,
                                            @Param("startTime") Long startTime,
                                            @Param("endTime") Long endTime,
                                            @Param("limit") int limit);

    @RequestLine("GET /api/v3/klines?symbol={symbol}&interval={interval}")
    List<KLine> getKLines(@Param("symbol") String symbol,
                          @Param(value = "interval", expander = KLineInterval.KLineIntervalExpander.class) KLineInterval interval);

    @RequestLine("GET /api/v3/klines?symbol={symbol}&interval={interval}&startTime={startTime}")
    List<KLine> getKLines(@Param("symbol") String symbol,
                          @Param(value = "interval", expander = KLineInterval.KLineIntervalExpander.class) KLineInterval interval,
                          @Param("startTime") Long startTime );

    @RequestLine("GET /api/v3/klines?symbol={symbol}&interval={interval}&limit={limit}")
    List<KLine> getKLines(@Param("symbol") String symbol,
                          @Param(value = "interval", expander = KLineInterval.KLineIntervalExpander.class) KLineInterval interval,
                          @Param("limit") int limit);

    @RequestLine("GET /api/v3/klines?symbol={symbol}&interval={interval}&startTime={startTime}&limit={limit}")
    List<KLine> getKLines(@Param("symbol") String symbol,
                          @Param(value = "interval", expander = KLineInterval.KLineIntervalExpander.class) KLineInterval interval,
                          @Param("startTime") Long startTime,
                          @Param("limit") int limit);

    @RequestLine("GET /api/v3/avgPrice?symbol={symbol}")
    AveragePrice getAveragePrice(@Param("symbol") String symbol);

    @RequestLine("GET /api/v3/ticker/24hr?symbol={symbol}")
    TickerChangeStatistics get24HourTickerChangeStatistics(@Param("symbol") String symbol);

    //GET /api/v3/ticker/price
    //GET /api/v3/ticker/bookTicker

}
