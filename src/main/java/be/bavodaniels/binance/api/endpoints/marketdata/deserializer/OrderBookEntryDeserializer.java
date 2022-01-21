package be.bavodaniels.binance.api.endpoints.marketdata.deserializer;

import be.bavodaniels.binance.api.endpoints.marketdata.model.OrderBookEntry;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class OrderBookEntryDeserializer extends JsonDeserializer<OrderBookEntry> {
    @Override
    public OrderBookEntry deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);
        final String price = node.get(0).asText();
        final String qty = node.get(1).asText();

        return  new OrderBookEntry(price, qty);
    }
}
