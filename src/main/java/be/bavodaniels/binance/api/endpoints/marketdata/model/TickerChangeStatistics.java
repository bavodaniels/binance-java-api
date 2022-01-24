package be.bavodaniels.binance.api.endpoints.marketdata.model;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Date;

public record TickerChangeStatistics(String symbol,
                                     String priceChange,
                                     String priceChangePercent,
                                     String weightedAvgPrice,
                                     String prevClosePrice,
                                     String lastPrice,
                                     String lastQty,
                                     String bidPrice,
                                     String askPrice,
                                     String openPrice,
                                     String highPrice,
                                     String lowPrice,
                                     String volume,
                                     String quoteVolume,
                                     Date openTime,
                                     Date closeTime,
                                     int firstId,
                                     int lastId,
                                     int count) {
}
