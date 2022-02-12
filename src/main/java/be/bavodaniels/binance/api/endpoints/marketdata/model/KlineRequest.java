package be.bavodaniels.binance.api.endpoints.marketdata.model;

import be.bavodaniels.binance.api.endpoints.general.model.KLineInterval;

public record KlineRequest(String symbol, KLineInterval interval) {
}
