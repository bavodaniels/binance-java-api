package be.bavodaniels.binance.api.endpoints.account;

import be.bavodaniels.binance.api.endpoints.account.model.PostOrderRequest;
import be.bavodaniels.binance.api.endpoints.account.model.PostOrderResponse;
import be.bavodaniels.binance.api.endpoints.marketdata.model.OrderBookLimit;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

public interface AccountEndpoint {
    @Headers("X-MBX-APIKEY: {apiKey}")
    @RequestLine(value = "POST /api/v3/order")
    PostOrderResponse postOrder(@QueryMap PostOrderRequest orderRequest,
                                @Param("apiKey") String apiKey);

    @Headers("X-MBX-APIKEY: {apiKey}")
    @RequestLine(value = "POST /api/v3/order/test")
    void postTestOrder(@QueryMap PostOrderRequest orderRequest,
                                @Param("apiKey") String apiKey);
}
