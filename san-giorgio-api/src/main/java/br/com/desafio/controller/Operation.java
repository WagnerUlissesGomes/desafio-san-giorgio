package br.com.desafio.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class Operation {

    private Integer sellerCode;
    private List<Payment> payments;

}
