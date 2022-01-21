package be.bavodaniels.binance.api.endpoints.general.model;

public record ExchangeFilter(FilterType filterType,
                             Integer limit) {
}
