package br.com.desafio.infra.provider.repo;

import br.com.desafio.domain.model.PaymentModel;
import br.com.desafio.domain.model.SellerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel, Integer> {

    List<PaymentModel> findAllBySeller(SellerModel seller);

    Optional<PaymentModel> findByBillingCode(String billingCode);

}
