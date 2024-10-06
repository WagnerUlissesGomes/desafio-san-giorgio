package br.com.desafio.controller;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Payment {

    private String billingCode;
    private BigDecimal paymentValue;
    private String paymentStatus;

}
