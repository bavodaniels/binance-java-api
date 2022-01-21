package be.bavodaniels.binance.api.endpoints.marketdata.model;

import be.bavodaniels.binance.api.endpoints.marketdata.deserializer.OrderBookEntryDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = OrderBookEntryDeserializer.class)
public record OrderBookEntry(String price,
                             String quantity) {
}
