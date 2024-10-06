package br.com.desafio.infra.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorMessage {

    private LocalDateTime timestamp;
    private Integer status;
    private String code;
    private String message;

}
