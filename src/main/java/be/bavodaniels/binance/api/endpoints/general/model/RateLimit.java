package be.bavodaniels.binance.api.endpoints.general.model;

public record RateLimit(RateLimitType rateLimitType,
                        RateLimitInterval interval,
                        Integer intervalNum, Integer limit) {
}
