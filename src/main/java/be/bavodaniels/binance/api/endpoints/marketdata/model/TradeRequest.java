package be.bavodaniels.binance.api.endpoints.marketdata.model;

public record TradeRequest(String symbol, OrderBookLimit limit) {
    public TradeRequest(String symbol) {
        this(symbol, null);
    }
}
