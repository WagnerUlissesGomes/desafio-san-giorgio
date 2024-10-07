package br.com.desafio.controller;


import br.com.desafio.domain.usecase.PaymentUseCase;
import br.com.desafio.domain.usecase.ProcessPaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@RequiredArgsConstructor
@RestController
public class PaymentController {

    @Autowired
    private ProcessPaymentUseCase useCase;

    @PostMapping(path = "/api/payment")
    public ResponseEntity<Operation> processPayment(@RequestBody Operation operation) {
        return ResponseEntity.ok().body(useCase.process(operation));
    }

    @GetMapping(path = "/api/payment")
    public ResponseEntity<String> getPayment() {
        return ResponseEntity.ok().body("Hello, World");
    }

}
