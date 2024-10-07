package br.com.desafio.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import br.com.desafio.SanGiorgioApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = SanGiorgioApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yml")
public class PaymentControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testGet() throws Exception {
        mvc.perform(get("/api/payment")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    void processPaymentSuccess() throws Exception {
        Payment payment = new Payment();
        payment.setBillingCode("1111 1111");
        payment.setPaymentValue(new BigDecimal("5.8"));

        Operation operation = new Operation();
        operation.setSellerCode(1);
        operation.setPayments(List.of(payment));

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(operation );

        mvc.perform(post("/api/payment", operation)
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());

    }
}
