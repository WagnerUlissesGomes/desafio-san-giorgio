package br.com.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.desafio")
public class SanGiorgioApplication {
    public static void main(String[] args) {
        SpringApplication.run(SanGiorgioApplication.class, args);
    }
}