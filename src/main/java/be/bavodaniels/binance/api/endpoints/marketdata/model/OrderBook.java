package be.bavodaniels.binance.api.endpoints.marketdata.model;

import java.util.List;

public record OrderBook(Long lastUpdateId,
                        List<OrderBookEntry> bids,
                        List<OrderBookEntry> asks) {
}
