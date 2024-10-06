package br.com.desafio.domain.usecase;


import br.com.desafio.domain.model.PaymentModel;
import br.com.desafio.domain.model.SellerModel;

import java.util.List;
import java.util.Optional;

public interface PaymentUseCase {

    List<PaymentModel> listAll();

    List<PaymentModel> listAll(SellerModel seller);

    Boolean isValid(String billingCode);

    Optional<PaymentModel> getByBillingCode(String billingCode);

    void save(PaymentModel paymentModel);
    
}
