package br.com.desafio.domain.usecase;

import br.com.desafio.controller.Operation;

public interface ProcessPaymentUseCase {

    Operation process(Operation operation);

}
