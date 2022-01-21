package be.bavodaniels.binance.api.endpoints.marketdata;

import be.bavodaniels.binance.api.config.Endpoint;
import be.bavodaniels.binance.api.endpoints.config.ApiConfig;
import be.bavodaniels.binance.api.endpoints.marketdata.model.OrderBook;
import be.bavodaniels.binance.api.endpoints.marketdata.model.OrderBookLimit;
import be.bavodaniels.binance.api.endpoints.marketdata.model.RecentTrade;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MarketDataEndpointTest {
    MarketDataEndpoint endpoint;
    ApiConfig config = new ApiConfig();
    @BeforeEach
    void setUp() {
        endpoint = Feign.builder()
                .decoder(new JacksonDecoder(List.of(new JavaTimeModule())))
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
}