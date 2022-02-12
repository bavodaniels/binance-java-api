package be.bavodaniels.binance.api.endpoints.marketdata;

import be.bavodaniels.binance.api.endpoints.account.AccountEndpoint;
import be.bavodaniels.binance.api.endpoints.general.GeneralEndpoint;
import be.bavodaniels.binance.api.endpoints.general.model.KLineInterval;
import be.bavodaniels.binance.api.endpoints.marketdata.model.*;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public interface MarketDataEndpoint {
    @RequestLine("GET /api/v3/depth?symbol={symbol}")
    OrderBook getOrderbook(@QueryMap DepthRequest request);

    @RequestLine("GET /api/v3/trades?symbol={symbol}")
    List<RecentTrade> getRecentTrades(@QueryMap TradeRequest request);

    @Headers("X-MBX-APIKEY: {apiKey}")
    @RequestLine("GET /api/v3/historicalTrades")
    List<RecentTrade> getHistoricalTrades(@QueryMap HistoricalTradesRequest request,
                                          @Param("apiKey") String apiKey);

    @RequestLine("GET /api/v3/aggTrades")
    List<AggregateTrade> getAggregateTrades(@QueryMap AggregateTradesRequest request);

    @RequestLine("GET /api/v3/klines")
    List<KLine> getKLines(@QueryMap KlineRequest request);

    @RequestLine("GET /api/v3/avgPrice?symbol={symbol}")
    AveragePrice getAveragePrice(@Param("symbol") String symbol);

    @RequestLine("GET /api/v3/ticker/24hr?symbol={symbol}")
    TickerChangeStatistics get24HourTickerChangeStatistics(@Param("symbol") String symbol);

    @RequestLine("GET /api/v3/ticker/price?symbol={symbol}")
    SymbolPrice getPrice(@Param("symbol") String symbol);

    @RequestLine("GET /api/v3/ticker/price")
    List<SymbolPrice> getAllPrices();
    //GET /api/v3/ticker/price
    //GET /api/v3/ticker/bookTicker

}
