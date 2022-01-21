package be.bavodaniels.binance.api.endpoints.marketdata;

import be.bavodaniels.binance.api.config.Endpoint;
import be.bavodaniels.binance.api.endpoints.marketdata.model.OrderBook;
import be.bavodaniels.binance.api.endpoints.marketdata.model.OrderBookLimit;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MarketDataEndpointTest {
    MarketDataEndpoint endpoint;
    @BeforeEach
    void setUp() {
        endpoint = Feign.builder()
                .decoder(new JacksonDecoder())
                .target(MarketDataEndpoint.class, Endpoint.API.getValue());
    }

    @Test
    void orderbook() {
        OrderBook orderbook = endpoint.orderbook("ETHBTC", OrderBookLimit.FIVE);

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
}