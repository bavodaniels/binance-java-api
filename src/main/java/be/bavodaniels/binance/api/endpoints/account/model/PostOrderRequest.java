package be.bavodaniels.binance.api.endpoints.account.model;

import be.bavodaniels.binance.api.endpoints.general.model.OrderResponseType;
import be.bavodaniels.binance.api.endpoints.general.model.OrderSide;
import be.bavodaniels.binance.api.endpoints.general.model.OrderType;
import be.bavodaniels.binance.api.endpoints.general.model.TimeInForce;

import java.awt.*;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public record PostOrderRequest(String symbol,
                               OrderSide side,
                               OrderType type,
                               TimeInForce timeInForce,
                               Double quantity,
                               Double quoteOrderQty,
                               Double price,
                               String newClientOrderId,
                               Double stopPrice,
                               Double icebergQty,
                               OrderResponseType newOrderRespType,
                               Long recvWindow,
                               Long timestamp) {
    public PostOrderRequest(String symbol, OrderSide side, OrderType type, TimeInForce timeInForce, Double quantity, Double quoteOrderQty, Double price, String newClientOrderId, Double stopPrice, Double icebergQty, OrderResponseType newOrderRespType, Long recvWindow) {
        this(symbol,
                side,
                type,
                timeInForce,
                quantity,
                quoteOrderQty,
                price,
                newClientOrderId,
                stopPrice,
                icebergQty,
                newOrderRespType,
                recvWindow,
                System.currentTimeMillis());
    }
}
