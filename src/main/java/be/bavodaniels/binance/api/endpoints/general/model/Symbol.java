package be.bavodaniels.binance.api.endpoints.general.model;

import lombok.Value;

import java.util.List;

public record Symbol(String symbol,
                     SymbolStatus status,
                     String baseAsset,
                     Integer baseAssetPrecision,
                     String quoteAsset,
                     Integer quoteAssetPrecision,
                     Integer baseCommissionPrecision,
                     Integer quoteCommissionPrecision,
                     List<OrderType> orderTypes,
                     Boolean icebergAllowed,
                     Boolean ocoAllowed,
                     Boolean quoteOrderQtyMarketAllowed,
                     Boolean isSpotTradingAllowed,
                     Boolean isMarginTradingAllowed,
                     List<SymbolFilter> filters) {
}
