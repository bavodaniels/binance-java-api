package be.bavodaniels.binance.api.endpoints.config;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.HexFormat;

/**
 * Utility class to sign messages using HMAC-SHA256.
 */
public class HmacSHA256Signer {
    private final static HexFormat hexFormat = HexFormat.of();

    public static String sign(String message, String secret) {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secretKeySpec);

            return hexFormat.formatHex(sha256_HMAC.doFinal(message.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Unable to sign message.", e);
        }
    }
}

