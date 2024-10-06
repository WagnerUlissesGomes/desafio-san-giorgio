package br.com.desafio.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tb_seller")
public class SellerModel {

    @Id
    @Column(name = "seller_id")
    private Integer id;

    @Column(name = "seller_name")
    private String name;

    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PaymentModel> payments;

}
