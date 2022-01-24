package be.bavodaniels.binance.api.endpoints.general;

import be.bavodaniels.binance.api.config.Endpoint;
import be.bavodaniels.binance.api.endpoints.general.model.ExchangeInfo;
import be.bavodaniels.binance.api.endpoints.general.model.Time;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GeneralEndpointTest {
    GeneralEndpoint endpoint;
    @BeforeEach
    void setUp() {
        endpoint = Feign.builder()
                .decoder(new JacksonDecoder())
                .target(GeneralEndpoint.class, Endpoint.TESTNET.getValue());
    }

    @Test
    void ping() {
        endpoint.ping();
    }

    @Test
    void time() {
        Time time = endpoint.getTime();

        assertThat(time).isNotNull();
        assertThat(time.serverTime()).isNotNull();
    }

    @Test
    void exchangeInfo() {
        ExchangeInfo exchangeInfo = endpoint.getExchangeInfo();

        assertThat(exchangeInfo).isNotNull();
    }
}