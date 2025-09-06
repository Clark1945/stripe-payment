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
    }

}
