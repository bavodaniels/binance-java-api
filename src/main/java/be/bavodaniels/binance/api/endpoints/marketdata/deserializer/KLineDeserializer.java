package be.bavodaniels.binance.api.endpoints.marketdata.deserializer;

import be.bavodaniels.binance.api.endpoints.marketdata.model.KLine;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

public class KLineDeserializer extends JsonDeserializer<KLine> {
    @Override
    public KLine deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);
        final Date openTime = Date.from(Instant.ofEpochMilli(node.get(0).asLong()));
        final String open = node.get(1).asText();
        final String high = node.get(2).asText();
        final String low = node.get(3).asText();
        final String close = node.get(4).asText();
        final String volume = node.get(5).asText();
        final Date closeTime = Date.from(Instant.ofEpochMilli(node.get(6).asLong()));
        final String quoteAssetVolume = node.get(7).asText();
        final Integer numberOfTrades = node.get(8).asInt();
        final String takerBuyBaseAssetVolumed = node.get(9).asText();
        final String takerBuyQuoteAssetVolumed = node.get(10).asText();

        return  new KLine(openTime,
                open,
                high,
                low,
                close,
                volume,
                closeTime,
                quoteAssetVolume,
                numberOfTrades,
                takerBuyBaseAssetVolumed,
                takerBuyQuoteAssetVolumed);
    }
}
