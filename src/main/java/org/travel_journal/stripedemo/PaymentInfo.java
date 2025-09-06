package org.travel_journal.stripedemo;


import java.util.Objects;

/**
 * Payment Object
 */
public class PaymentInfo {
    private Long amount;
    private String paymentMethodId;
    private String currency;
    private final CustomerInfo customerInfo;

    public PaymentInfo(Long amount, String paymentMethodId, String currency, CustomerInfo customerInfo) {
        this.amount = amount;
        this.paymentMethodId = paymentMethodId;
        this.currency = currency;
        this.customerInfo = customerInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PaymentInfo that = (PaymentInfo) o;
        return Objects.equals(amount, that.amount) && Objects.equals(paymentMethodId, that.paymentMethodId) && Objects.equals(currency, that.currency) && Objects.equals(customerInfo, that.customerInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, paymentMethodId, currency, customerInfo);
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public static class CustomerInfo {
        private String name;
        private String email;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    }
}
