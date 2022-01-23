package be.bavodaniels.binance.api.endpoints.marketdata.model;

import be.bavodaniels.binance.api.endpoints.marketdata.deserializer.KLineDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

@JsonDeserialize(using = KLineDeserializer.class)
public record KLine(Date openTime,
                    String open,
                    String high,
                    String low,
                    String close,
                    String volume,
                    Date closeTime,
                    String quoteAssetVolume,
                    Integer numberOfTrades,
                    String takerBuyBaseAssetVolume,
                    String takerBuyQuoteAssetVolume) {
}
