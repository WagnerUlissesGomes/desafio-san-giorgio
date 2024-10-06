package br.com.desafio.infra.provider.repo;

import br.com.desafio.domain.model.SellerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<SellerModel, Integer> {
}
