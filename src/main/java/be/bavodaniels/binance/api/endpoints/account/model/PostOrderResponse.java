package be.bavodaniels.binance.api.endpoints.account.model;

import be.bavodaniels.binance.api.endpoints.general.model.OrderSide;
import be.bavodaniels.binance.api.endpoints.general.model.OrderStatus;
import be.bavodaniels.binance.api.endpoints.general.model.OrderType;
import be.bavodaniels.binance.api.endpoints.general.model.TimeInForce;

import java.util.Date;
import java.util.List;

public record PostOrderResponse(String symbol,
                                Integer orderId,
                                Integer orderListId,
                                String clientOrderId,
                                Date transactTime,
                                String price,
                                String origQty,
                                String executedQty,
                                String cummulativeQuoteQty,
                                OrderStatus status,
                                TimeInForce timeInForce,
                                OrderType type,
                                OrderSide side,
                                List<OrderFill> fills
                                ) {
}
