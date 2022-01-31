package be.bavodaniels.binance.api.endpoints.marketdata.model;

public record DepthRequest(String symbol, OrderBookLimit limit) {
    public DepthRequest(String symbol) {
        this(symbol, null);
    }
}
