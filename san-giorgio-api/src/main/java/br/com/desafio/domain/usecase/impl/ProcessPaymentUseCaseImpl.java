package br.com.desafio.domain.usecase.impl;

import br.com.desafio.controller.Operation;
import br.com.desafio.domain.model.PaymentModel;
import br.com.desafio.domain.model.PaymentStatus;
import br.com.desafio.domain.usecase.PaymentUseCase;
import br.com.desafio.domain.usecase.ProcessPaymentUseCase;
import br.com.desafio.domain.usecase.SellerUseCase;
import br.com.desafio.infra.exception.BusinessException;
import br.com.desafio.infra.provider.queue.AwsSQS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessPaymentUseCaseImpl implements ProcessPaymentUseCase {

    @Autowired
    private SellerUseCase sellerUseCase;

    @Autowired
    private PaymentUseCase paymentUseCase;

    @Autowired
    private AwsSQS awsSQS;

    @Override
    public Operation process(Operation operation) {
        validate(operation);

        operation.getPayments().forEach(payment -> {
            PaymentModel paymentModel = paymentUseCase.getByBillingCode(payment.getBillingCode()).orElseThrow();
            PaymentStatus status = PaymentStatus.TOTAL;
            if (payment.getPaymentValue().compareTo(paymentModel.getOriginalValue()) < 0) {
                // parcial
                status = PaymentStatus.PARCIAL;
            } else if (payment.getPaymentValue().compareTo(paymentModel.getOriginalValue()) > 0) {
                // excedido
                status = PaymentStatus.EXCEDENTE;
            }
            payment.setPaymentStatus(status.name());
            paymentModel.setStatus(status);
            paymentModel.setAmountPaid(payment.getPaymentValue());
            paymentUseCase.save(paymentModel);
            awsSQS.sendToQueue(paymentModel);
        });

        return operation;
    }

    private void validate(Operation operation) {
        if (!sellerUseCase.isValid(operation.getSellerCode())) {
            throw new BusinessException("0001", "Vendedor não foi encontrado.");
        }

        operation.getPayments().forEach(payment -> {
            if (!paymentUseCase.isValid(payment.getBillingCode())) {
                throw new BusinessException("0002", "O código da cobrança %s não foi encontrado.".formatted(payment.getBillingCode()));
            }
        });
    }

}
