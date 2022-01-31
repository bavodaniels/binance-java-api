package be.bavodaniels.binance.api.endpoints.marketdata.model;

public record HistoricalTradesRequest(String symbol,
                                      Integer limit,
                                      Long fromId) {
    public HistoricalTradesRequest(String symbol) {
        this(symbol, null, null);
    }

    public HistoricalTradesRequest(String symbol, Integer limit) {
        this(symbol, limit, null);
    }

    public HistoricalTradesRequest(String symbol, Long fromId) {
        this(symbol, null, fromId);
    }

    public HistoricalTradesRequest(String symbol, Integer limit, Long fromId) {
        this.symbol = symbol;
        this.limit = limit;
        this.fromId = fromId;
    }
}
