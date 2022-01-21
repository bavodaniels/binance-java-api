package be.bavodaniels.binance.api.endpoints.general.model;

public record SymbolFilter(FilterType filterType,
                           String minPrice,
                           String maxPrice,
                           String tickSize,
                           String multiplierUp,
                           String multiplierDown,
                           Integer avgPriceMins) { }
