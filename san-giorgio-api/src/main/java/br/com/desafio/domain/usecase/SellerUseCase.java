package br.com.desafio.domain.usecase;

import br.com.desafio.domain.model.SellerModel;

import java.util.List;
import java.util.Optional;

public interface SellerUseCase {

    Optional<SellerModel> getById(Integer id);

    List<SellerModel> listAll();

    Boolean isValid(Integer id);

}
