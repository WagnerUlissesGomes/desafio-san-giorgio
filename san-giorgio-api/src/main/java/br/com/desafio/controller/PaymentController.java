package br.com.desafio.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@RequiredArgsConstructor
@RestController
public class PaymentController {

    //private final ConfirmPaymentUseCase confirmPaymentUseCase;

    @PutMapping(path = "/api/payment")
    public ResponseEntity<Payment> setPayment(Payment request) {


        return ResponseEntity.status(HttpStatus.OK).body(Payment.builder().build());
    }
}
