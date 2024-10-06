package br.com.desafio.domain.usecase.impl;

import br.com.desafio.domain.model.PaymentModel;
import br.com.desafio.domain.model.SellerModel;
import br.com.desafio.domain.usecase.PaymentUseCase;
import br.com.desafio.infra.provider.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentUseCaseImpl implements PaymentUseCase {

    @Autowired
    private PaymentRepository repository;

    @Override
    public List<PaymentModel> listAll() {
        return repository.findAll();
    }

    @Override
    public List<PaymentModel> listAll(SellerModel seller) {
        return repository.findAllBySeller(seller);
    }

    @Override
    public Boolean isValid(String billingCode) {
        return getByBillingCode(billingCode).isPresent();
    }

    @Override
    public Optional<PaymentModel> getByBillingCode(String billingCode) {
        return repository.findByBillingCode(billingCode);
    }

    @Override
    public void save(PaymentModel paymentModel) {
        repository.save(paymentModel);
    }
}
