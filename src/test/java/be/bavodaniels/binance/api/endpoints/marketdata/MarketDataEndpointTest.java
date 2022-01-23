package be.bavodaniels.binance.api.endpoints.marketdata;

import be.bavodaniels.binance.api.config.Endpoint;
import be.bavodaniels.binance.api.endpoints.config.ApiConfig;
import be.bavodaniels.binance.api.endpoints.general.model.KLineInterval;
import be.bavodaniels.binance.api.endpoints.marketdata.model.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MarketDataEndpointTest {
    MarketDataEndpoint endpoint;
    ApiConfig config = new ApiConfig();
    @BeforeEach
    void setUp() {
        endpoint = Feign.builder()
                .encoder(new JacksonEncoder(List.of(new JavaTimeModule())))
                .decoder(new JacksonDecoder(List.of(new JavaTimeModule())))
                .logLevel(Logger.Level.FULL)
                .target(MarketDataEndpoint.class, Endpoint.API.getValue());
    }

    @Test
    void orderbook_withLimit() {
        OrderBook orderbook = endpoint.getOrderbook("ETHBTC", OrderBookLimit.FIVE);

        assertThat(orderbook).isNotNull();
        assertThat(orderbook.lastUpdateId()).isNotEqualTo(0L);
        assertThat(orderbook.asks()).isNotNull();
        assertThat(orderbook.asks().get(0)).isNotNull();
        assertThat(orderbook.asks().get(0).price()).isNotNull();
        assertThat(orderbook.asks().get(0).quantity()).isNotNull();
        assertThat(orderbook.bids()).isNotNull();
        assertThat(orderbook.bids().get(0)).isNotNull();
        assertThat(orderbook.bids().get(0).price()).isNotNull();
        assertThat(orderbook.bids().get(0).quantity()).isNotNull();
    }

    @Test
    void orderbook() {
        OrderBook orderbook = endpoint.getOrderbook("ETHBTC");

        assertThat(orderbook).isNotNull();
        assertThat(orderbook.lastUpdateId()).isNotEqualTo(0L);
        assertThat(orderbook.asks()).isNotNull();
        assertThat(orderbook.asks().get(0)).isNotNull();
        assertThat(orderbook.asks().get(0).price()).isNotNull();
        assertThat(orderbook.asks().get(0).quantity()).isNotNull();
        assertThat(orderbook.bids()).isNotNull();
        assertThat(orderbook.bids().get(0)).isNotNull();
        assertThat(orderbook.bids().get(0).price()).isNotNull();
        assertThat(orderbook.bids().get(0).quantity()).isNotNull();
    }

    @Test
    void recentTrades_withLimit() {
        List<RecentTrade> trades = endpoint.getRecentTrades("ETHBTC", 1);

        assertThat(trades).isNotNull();
        assertThat(trades.get(0)).isNotNull();
        assertThat(trades.get(0).time()).isNotNull();
        assertThat(trades.get(0).price()).isNotNull();
        assertThat(trades.get(0).qty()).isNotNull();
        assertThat(trades.get(0).quoteQty()).isNotNull();
    }

    @Test
    void recentTrades() {
        List<RecentTrade> trades = endpoint.getRecentTrades("ETHBTC");

        assertThat(trades).isNotNull();
        assertThat(trades.get(0)).isNotNull();
        assertThat(trades.get(0).time()).isNotNull();
        assertThat(trades.get(0).price()).isNotNull();
        assertThat(trades.get(0).qty()).isNotNull();
        assertThat(trades.get(0).quoteQty()).isNotNull();
    }

    @Test
    void historicalTrades() {
        List<RecentTrade> trades = endpoint.getHistoricalTrades("ETHBTC", config.getApiKey());

        assertThat(trades).isNotNull();
        assertThat(trades.get(0)).isNotNull();
        assertThat(trades.get(0).time()).isNotNull();
        assertThat(trades.get(0).price()).isNotNull();
        assertThat(trades.get(0).qty()).isNotNull();
        assertThat(trades.get(0).quoteQty()).isNotNull();
    }

    @Test
    void historicalTrades_withLimit() {
        List<RecentTrade> trades = endpoint.getHistoricalTrades("ETHBTC", 1, config.getApiKey());

        assertThat(trades).isNotNull();
        assertThat(trades.get(0)).isNotNull();
        assertThat(trades.get(0).time()).isNotNull();
        assertThat(trades.get(0).price()).isNotNull();
        assertThat(trades.get(0).qty()).isNotNull();
        assertThat(trades.get(0).quoteQty()).isNotNull();
    }

    @Test
    void historicalTrades_withFromId() {
        List<RecentTrade> trades = endpoint.getHistoricalTrades("ETHBTC", 1L, config.getApiKey()    );

        assertThat(trades).isNotNull();
        assertThat(trades.get(0)).isNotNull();
        assertThat(trades.get(0).time()).isNotNull();
        assertThat(trades.get(0).price()).isNotNull();
        assertThat(trades.get(0).qty()).isNotNull();
        assertThat(trades.get(0).quoteQty()).isNotNull();
    }

    @Test
    void historicalTrades_withLimitAndFromId() {
        List<RecentTrade> trades = endpoint.getHistoricalTrades("ETHBTC", 1, 1L, config.getApiKey());

        assertThat(trades).isNotNull();
        assertThat(trades.get(0)).isNotNull();
        assertThat(trades.get(0).time()).isNotNull();
        assertThat(trades.get(0).price()).isNotNull();
        assertThat(trades.get(0).qty()).isNotNull();
        assertThat(trades.get(0).quoteQty()).isNotNull();
    }

    @Test
    void aggregateTrades() {
        List<AggregateTrade> trades = endpoint.getAggregateTrades("ETHBTC");

        assertThat(trades).isNotNull();
        assertThat(trades.get(0)).isNotNull();
        assertThat(trades.get(0).firstTradeId()).isNotNull();
        assertThat(trades.get(0).lastTradeId()).isNotNull();
        assertThat(trades.get(0).isBestMatch()).isNotNull();
        assertThat(trades.get(0).isMaker()).isNotNull();
        assertThat(trades.get(0).quantity()).isNotNull();
        assertThat(trades.get(0).price()).isNotNull();
        assertThat(trades.get(0).time()).isNotNull();
    }

    @Test
    void aggregateTrades_withLimit() {
        List<AggregateTrade> trades = endpoint.getAggregateTrades("ETHBTC", 1);

        assertThat(trades).isNotNull();
        assertThat(trades.get(0)).isNotNull();
        assertThat(trades.get(0).firstTradeId()).isNotNull();
        assertThat(trades.get(0).lastTradeId()).isNotNull();
        assertThat(trades.get(0).isBestMatch()).isNotNull();
        assertThat(trades.get(0).isMaker()).isNotNull();
        assertThat(trades.get(0).quantity()).isNotNull();
        assertThat(trades.get(0).price()).isNotNull();
        assertThat(trades.get(0).time()).isNotNull();
    }

    @Test
    void aggregateTrades_withFromId() {
        List<AggregateTrade> trades = endpoint.getAggregateTrades("ETHBTC", 1L);

        assertThat(trades).isNotNull();
        assertThat(trades.get(0)).isNotNull();
        assertThat(trades.get(0).firstTradeId()).isNotNull();
        assertThat(trades.get(0).lastTradeId()).isNotNull();
        assertThat(trades.get(0).isBestMatch()).isNotNull();
        assertThat(trades.get(0).isMaker()).isNotNull();
        assertThat(trades.get(0).quantity()).isNotNull();
        assertThat(trades.get(0).price()).isNotNull();
        assertThat(trades.get(0).time()).isNotNull();
    }

    @Test
    void aggregateTrades_withFromIdAndLimit() {
        List<AggregateTrade> trades = endpoint.getAggregateTrades("ETHBTC", 1L, 1);

        assertThat(trades).isNotNull();
        assertThat(trades.get(0)).isNotNull();
        assertThat(trades.get(0).firstTradeId()).isNotNull();
        assertThat(trades.get(0).lastTradeId()).isNotNull();
        assertThat(trades.get(0).isBestMatch()).isNotNull();
        assertThat(trades.get(0).isMaker()).isNotNull();
        assertThat(trades.get(0).quantity()).isNotNull();
        assertThat(trades.get(0).price()).isNotNull();
        assertThat(trades.get(0).time()).isNotNull();
    }

    @Test
    void aggregateTrades_withStartTimeAndEndTime() {
        List<AggregateTrade> trades = endpoint.getAggregateTrades("ETHBTC", System.currentTimeMillis()-100000, System.currentTimeMillis());

        assertThat(trades).isNotNull();
        assertThat(trades.get(0)).isNotNull();
        assertThat(trades.get(0).firstTradeId()).isNotNull();
        assertThat(trades.get(0).lastTradeId()).isNotNull();
        assertThat(trades.get(0).isBestMatch()).isNotNull();
        assertThat(trades.get(0).isMaker()).isNotNull();
        assertThat(trades.get(0).quantity()).isNotNull();
        assertThat(trades.get(0).price()).isNotNull();
        assertThat(trades.get(0).time()).isNotNull();
    }

    @Test
    void aggregateTrades_withStartTimeAndEndTimeAndLimit() {
        List<AggregateTrade> trades = endpoint.getAggregateTrades("ETHBTC", System.currentTimeMillis()-10000,System.currentTimeMillis(), 1);

        assertThat(trades).isNotNull();
        assertThat(trades.get(0)).isNotNull();
        assertThat(trades.get(0).firstTradeId()).isNotNull();
        assertThat(trades.get(0).lastTradeId()).isNotNull();
        assertThat(trades.get(0).isBestMatch()).isNotNull();
        assertThat(trades.get(0).isMaker()).isNotNull();
        assertThat(trades.get(0).quantity()).isNotNull();
        assertThat(trades.get(0).price()).isNotNull();
        assertThat(trades.get(0).time()).isNotNull();
    }

    @Test
    void testKLine() {
        List<KLine> klines = endpoint.getKLines("ETHBTC", KLineInterval.ONE_DAY);

        assertThat(klines).isNotNull()
                .hasSize(500);
        assertThat(klines.get(0).close()).isNotNull();
        assertThat(klines.get(0).closeTime()).isNotNull();
        assertThat(klines.get(0).high()).isNotNull();
        assertThat(klines.get(0).low()).isNotNull();
        assertThat(klines.get(0).numberOfTrades()).isNotNull();
        assertThat(klines.get(0).open()).isNotNull();
        assertThat(klines.get(0).openTime()).isNotNull();
        assertThat(klines.get(0).quoteAssetVolume()).isNotNull();
        assertThat(klines.get(0).takerBuyBaseAssetVolume()).isNotNull();
        assertThat(klines.get(0).takerBuyQuoteAssetVolume()).isNotNull();
    }

    @Test
    void testKLine_withLimit() {
        List<KLine> klines = endpoint.getKLines("ETHBTC", KLineInterval.ONE_DAY, 1);

        assertThat(klines).isNotNull()
                .hasSize(1);
        assertThat(klines.get(0).close()).isNotNull();
        assertThat(klines.get(0).closeTime()).isNotNull();
        assertThat(klines.get(0).high()).isNotNull();
        assertThat(klines.get(0).low()).isNotNull();
        assertThat(klines.get(0).numberOfTrades()).isNotNull();
        assertThat(klines.get(0).open()).isNotNull();
        assertThat(klines.get(0).openTime()).isNotNull();
        assertThat(klines.get(0).quoteAssetVolume()).isNotNull();
        assertThat(klines.get(0).takerBuyBaseAssetVolume()).isNotNull();
        assertThat(klines.get(0).takerBuyQuoteAssetVolume()).isNotNull();
    }

    @Test
    void testKLine_withStartTime() {
        List<KLine> klines = endpoint.getKLines("ETHBTC", KLineInterval.ONE_DAY, LocalDateTime.now().minusDays(1L)
                .toInstant(ZoneOffset.UTC).toEpochMilli());

        assertThat(klines).isNotNull()
                .hasSize(1);
        assertThat(klines.get(0).close()).isNotNull();
        assertThat(klines.get(0).closeTime()).isNotNull();
        assertThat(klines.get(0).high()).isNotNull();
        assertThat(klines.get(0).low()).isNotNull();
        assertThat(klines.get(0).numberOfTrades()).isNotNull();
        assertThat(klines.get(0).open()).isNotNull();
        assertThat(klines.get(0).openTime()).isNotNull();
        assertThat(klines.get(0).quoteAssetVolume()).isNotNull();
        assertThat(klines.get(0).takerBuyBaseAssetVolume()).isNotNull();
        assertThat(klines.get(0).takerBuyQuoteAssetVolume()).isNotNull();
    }

    @Test
    void testKLine_withStartTimeAndLimit() {
        List<KLine> klines = endpoint.getKLines("ETHBTC", KLineInterval.ONE_DAY, LocalDateTime.now().minusDays(2L)
                .toInstant(ZoneOffset.UTC).toEpochMilli(), 1);

        assertThat(klines).isNotNull()
                .hasSize(1);
        assertThat(klines.get(0).close()).isNotNull();
        assertThat(klines.get(0).closeTime()).isNotNull();
        assertThat(klines.get(0).high()).isNotNull();
        assertThat(klines.get(0).low()).isNotNull();
        assertThat(klines.get(0).numberOfTrades()).isNotNull();
        assertThat(klines.get(0).open()).isNotNull();
        assertThat(klines.get(0).openTime()).isNotNull();
        assertThat(klines.get(0).quoteAssetVolume()).isNotNull();
        assertThat(klines.get(0).takerBuyBaseAssetVolume()).isNotNull();
        assertThat(klines.get(0).takerBuyQuoteAssetVolume()).isNotNull();
    }
}