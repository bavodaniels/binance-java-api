package be.bavodaniels.binance.api.endpoints.config;

public class ApiConfig {
    public String getApiKey(){
        return System.getenv("BINANCE_API");
    }
}