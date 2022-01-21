package be.bavodaniels.binance.api.endpoints.marketdata.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

public record RecentTrade(int id,
                          String price,
                          String qty,
                          String quoteQty,
                          Date time,
                          boolean isBuyerMaker,
                          boolean isBestMatch) {
}
