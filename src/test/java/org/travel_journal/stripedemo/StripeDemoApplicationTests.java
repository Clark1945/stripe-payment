package org.travel_journal.stripedemo;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.net.RequestOptions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StripeDemoApplicationTests {

    @Test
    void contextLoads() throws StripeException {
        Stripe.apiKey = "sk_test_26PHem9AhJZvU623DfE1x4sd";
        RequestOptions requestOptions = RequestOptions.builder()
                .setApiKey("sk_test_26PHem9AhJZvU623DfE1x4sd")
                .build();
        Charge charge = Charge.retrieve("ch_3Ln3ga2eZvKYlo2C11iwHdxy", requestOptions);

    }

}
