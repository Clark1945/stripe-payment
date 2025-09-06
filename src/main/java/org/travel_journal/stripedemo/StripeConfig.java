package org.travel_journal.stripedemo;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StripeConfig {

    @Value("${stripe.api-key}")
    private String apiKey;

    // Globally set stripe API Key.
    @PostConstruct
    public void init() {
        Stripe.apiKey = apiKey;
    }
}
