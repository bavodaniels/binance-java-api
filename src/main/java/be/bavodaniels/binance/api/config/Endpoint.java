package be.bavodaniels.binance.api.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Endpoint {
    API("https://api.binance.com"),
    API1("https://api1.binance.com"),
    API2("https://api2.binance.com"),
    API3("https://api3.binance.com");

    private final String value;
}
