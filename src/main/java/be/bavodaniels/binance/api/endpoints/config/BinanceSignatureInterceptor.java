package be.bavodaniels.binance.api.endpoints.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class BinanceSignatureInterceptor implements RequestInterceptor {
    private final ApiConfig apiConfig;

    public BinanceSignatureInterceptor(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    @Override
    public void apply(RequestTemplate template) {
        template.query("signature", HmacSHA256Signer.sign(template.queryLine().substring(1), apiConfig.getTestNetSecret()));
    }
}
