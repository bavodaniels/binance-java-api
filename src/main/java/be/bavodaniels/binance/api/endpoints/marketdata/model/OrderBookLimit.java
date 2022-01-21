package be.bavodaniels.binance.api.endpoints.marketdata.model;

import feign.Param.Expander;

public enum OrderBookLimit {
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100),
    FIVE_HUNDRED(500),
    THOUSAND(1000),
    FIVE_THOUSAND(5000);

    private final int limit;

    OrderBookLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public static final class OrderBookLimitExpander implements Expander {

        @Override
        public String expand(Object value) {
            return String.valueOf(((OrderBookLimit)value).getLimit());
        }
    }
}
