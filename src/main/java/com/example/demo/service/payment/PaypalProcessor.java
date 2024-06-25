package com.example.demo.service.payment;

import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

//@ToString
@Service("paypal")
public class PaypalProcessor implements PaymentProcessor {
    private final int PAYPAL_MAX_AMOUNT = 100_000;

    @Override
    public boolean isPaymentSuccessful(BigDecimal amount) throws Exception {
        makePayment(bigDecimalToInt(amount));
        return true;
    }

    private void makePayment(int amount) throws Exception {
        if (amount > PAYPAL_MAX_AMOUNT) {
            throw new Exception("Amount exceeds the limit for Paypal");
        }
    }

    private int bigDecimalToInt(BigDecimal amount) {
        return amount.setScale(0, RoundingMode.CEILING).intValue();
    }
}


//    @Override
//    public String getProcessorName() {
//        return name;
//    }

//public class PaypalPaymentProcessor implements PaymentProcessor {

//    private final String name;

//    public PaypalPaymentProcessor(@Value("${PAYPAL.PAYMENT.NAME}") String name) {
//        this.name = name;
//    }