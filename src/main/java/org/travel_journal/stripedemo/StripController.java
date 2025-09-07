package org.travel_journal.stripedemo;

import com.stripe.exception.*;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentMethod;
import com.stripe.param.PaymentIntentCreateParams;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import org.slf4j.Logger;

@RestController
@RequestMapping("/stripe")
public class StripController {

    private static final Logger log = LoggerFactory.getLogger(StripController.class);


    @PostMapping("/pay")
    public ResponseEntity charge(@RequestBody PaymentInfo paymentInfo) {
        String paymentMethodId = paymentInfo.getPaymentMethodId();
        //
        Long amount = paymentInfo.getAmount();
        String currency = paymentInfo.getCurrency();
        amount = currency.equalsIgnoreCase("twd") ? amount * 100 : amount;
        String customer = paymentInfo.getCustomerInfo().getName();
        String email = paymentInfo.getCustomerInfo().getEmail();
        try {
            log.info("customer:{}開始付款...",customer);
            // Use Stripe's library to make requests...
            PaymentIntentCreateParams params =
                    PaymentIntentCreateParams.builder()
                            .setAmount(amount)
                            .setCurrency(currency)
                            .setAutomaticPaymentMethods(
                                    PaymentIntentCreateParams.AutomaticPaymentMethods.builder()
                                            .setEnabled(true)
                                            .build()
                            )
                            .setPaymentMethod(paymentMethodId)
                            .setReceiptEmail(email)
                            .build();
            PaymentIntent paymentIntent = PaymentIntent.create(params);
            System.out.println(paymentIntent.toJson());
            // 把 secret回給前端的Stripe.js驗證
            return ResponseEntity.ok(Map.of("clientSecret", paymentIntent.getClientSecret()));
        } catch (CardException e) {
            // Since it's a decline, CardException will be caught
            System.out.println("Status is: " + e.getCode());
            System.out.println("Message is: " + e.getMessage());
            return ResponseEntity.ok(e.getMessage());
        } catch (RateLimitException e) {
            // Too many requests made to the API too quickly
            System.out.println(e.getMessage());
            return ResponseEntity.ok(e.getMessage());
        } catch (InvalidRequestException e) {
            // Invalid parameters were supplied to Stripe's API
            System.out.println(e.getMessage());
            return ResponseEntity.ok(e.getMessage());
        } catch (AuthenticationException e) {
            // Authentication with Stripe's API failed
            // (maybe you changed API keys recently)
            System.out.println(e.getMessage());
            return ResponseEntity.ok(e.getMessage());
        } catch (ApiConnectionException e) {
            // Network communication with Stripe failed
            System.out.println(e.getMessage());
            return ResponseEntity.ok(e.getMessage());
        } catch (StripeException e) {
            // Display a very generic error to the user, and maybe send
            // yourself an email
            System.out.println(e.getMessage());
            return ResponseEntity.ok(e.getMessage());
        } catch (Exception e) {
            // Something else happened, completely unrelated to Stripe
            System.out.println(e.getMessage());
            return ResponseEntity.ok(e.getMessage());
        } finally {
            log.info("customer:{}付款結束...",customer);
        }
    }

    @GetMapping("/check")
    public String check() {
        return "I'm alive!";
    }
}
