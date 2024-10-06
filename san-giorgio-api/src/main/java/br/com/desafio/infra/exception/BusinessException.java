package br.com.desafio.infra.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private String code;

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }
}
