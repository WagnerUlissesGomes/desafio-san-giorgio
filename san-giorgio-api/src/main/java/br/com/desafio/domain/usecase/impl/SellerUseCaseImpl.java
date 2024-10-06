package br.com.desafio.domain.usecase.impl;

import br.com.desafio.domain.model.SellerModel;
import br.com.desafio.domain.usecase.SellerUseCase;
import br.com.desafio.infra.provider.repo.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerUseCaseImpl implements SellerUseCase {

    @Autowired
    private SellerRepository repository;

    @Override
    public Optional<SellerModel> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<SellerModel> listAll() {
        System.out.println("listAll");
        return repository.findAll();
    }

    @Override
    public Boolean isValid(Integer id) {
        return repository.findById(id).isPresent();
    }
}
