package br.com.desafio.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PaymentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void processPaymentSuccess() {
        URI uri = URI.create("http://localhost:8080/api/payment");
        Operation operation = new Operation();
        operation.setSellerCode(1);
        operation.setPayments(new ArrayList<>());
        Payment payment = new Payment();
        payment.setBillingCode("4444 4444");
        payment.setPaymentValue(new BigDecimal("10.1"));
        operation.getPayments().add(payment);
        Operation oper = restTemplate.postForObject(uri, operation, Operation.class);
        assertNotNull(oper);
    }
}
