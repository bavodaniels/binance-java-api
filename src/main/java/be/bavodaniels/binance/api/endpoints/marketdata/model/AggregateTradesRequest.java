package be.bavodaniels.binance.api.endpoints.marketdata.model;


import java.util.Objects;

public record AggregateTradesRequest(String symbol,
                                     Long fromId,
                                     Long startTime,
                                     Long endTime,
                                     Integer limit) {
    public AggregateTradesRequest {
        Objects.requireNonNull(symbol);
    }
}
