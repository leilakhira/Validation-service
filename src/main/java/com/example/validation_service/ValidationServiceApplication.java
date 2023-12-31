package com.example.validation_service;

import com.example.validation_service.Entite.Valideur;
import com.example.validation_service.Repository.ValideurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class ValidationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidationServiceApplication.class, args);
    }
    CommandLineRunner start(ValideurRepository valideurRepository) {
        return args -> {
            Valideur v1 = new Valideur("touili","yassir","yassirtouili@gmail.com");
            Valideur v2 = new Valideur("khira","leila","leilakhira@gmail.com");
            valideurRepository.save(v1);
            valideurRepository.save(v2);
            valideurRepository.save(v1);
            valideurRepository.save(v2);
        };
    }

}
