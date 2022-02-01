package be.bavodaniels.binance.api.endpoints.account;

import be.bavodaniels.binance.api.config.Endpoint;
import be.bavodaniels.binance.api.endpoints.account.model.PostOrderRequest;
import be.bavodaniels.binance.api.endpoints.account.model.PostOrderResponse;
import be.bavodaniels.binance.api.endpoints.config.ApiConfig;
import be.bavodaniels.binance.api.endpoints.config.BinanceSignatureInterceptor;
import be.bavodaniels.binance.api.endpoints.general.model.OrderSide;
import be.bavodaniels.binance.api.endpoints.general.model.OrderType;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountEndpointTest {
    private AccountEndpoint endpoint;
    private ApiConfig apiConfig = new ApiConfig();

    @BeforeEach
    void setUp() {
        endpoint = Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .requestInterceptor(new BinanceSignatureInterceptor(apiConfig))
                .target(AccountEndpoint.class, Endpoint.TESTNET.getValue());
    }

    @Test
    void testOnlyRequiredParams() {
        PostOrderResponse response = endpoint.postOrder(new PostOrderRequest("ETHBTC",
                OrderSide.BUY,
                OrderType.MARKET,
                null,
                1.0,
                null,
                null,
                null,
                null,
                null,
                null,
                null),
                apiConfig.getTestNetApi());

        assertThat(response).isNotNull();
    }

    @Test
    void testOrder() {
        endpoint.postTestOrder(new PostOrderRequest("ETHBTC",
                        OrderSide.BUY,
                        OrderType.MARKET,
                        null,
                        1.0,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null),
                apiConfig.getTestNetApi());

    }
}