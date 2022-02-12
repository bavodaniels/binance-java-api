package be.bavodaniels.binance.api.endpoints.marketdata.model;


import be.bavodaniels.binance.api.endpoints.general.model.Symbol;
import jdk.dynalink.beans.StaticClass;

import java.util.Date;
import java.util.Objects;

public record AggregateTradesRequest(String symbol,
                                     Long fromId,
                                     Long startTime,
                                     Long endTime,
                                     Integer limit) {
    public AggregateTradesRequest {
        Objects.requireNonNull(symbol);
    }

    public static AggregateTradesRequest build(String symbol){
        return new AggregateTradesRequest(symbol, null, null, null, null);
    }

    public static AggregateTradesRequest build(String symbol, int limit){
        return new AggregateTradesRequest(symbol, null, null, null, limit);
    }

    public static AggregateTradesRequest build(String symbol, Date startTime){
        return new AggregateTradesRequest(symbol, null, startTime.getTime(), null, null);
    }

    public static AggregateTradesRequest build(String symbol, Date startTime, int limit){
        return new AggregateTradesRequest(symbol, null, startTime.getTime(), null, limit);
    }
}
