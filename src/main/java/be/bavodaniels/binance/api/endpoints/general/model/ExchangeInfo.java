package be.bavodaniels.binance.api.endpoints.general.model;

import java.util.List;

public record ExchangeInfo(String timezone, Long serverTime,
                           List<RateLimit> rateLimits,
                           List<ExchangeFilter> exchangeFilters,
                           List<Symbol> symbols) {
}
