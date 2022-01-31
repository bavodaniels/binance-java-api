package be.bavodaniels.binance.api.endpoints.account.model;

public record OrderFill(String price,
                        String qty,
                        String comission,
                        String commissionAsset) {
}
