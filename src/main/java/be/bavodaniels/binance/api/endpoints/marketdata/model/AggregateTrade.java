package be.bavodaniels.binance.api.endpoints.marketdata.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Date;

public record AggregateTrade(@JsonProperty("a") Integer a,
                             @JsonProperty("p") String price,
                             @JsonProperty("q") String quantity,
                             @JsonProperty("f") Integer firstTradeId,
                             @JsonProperty("l") Integer lastTradeId,
                             @JsonProperty("T") Date time,
                             @JsonProperty("m") Boolean isMaker,
                             @JsonProperty("M") Boolean isBestMatch
                             ) {
}
