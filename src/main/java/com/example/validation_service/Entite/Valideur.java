package com.example.validation_service.Entite;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Valideur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long valideur_id;
    @Column
    private String name;
    @Column
    private String prenom;
    @Column
    private String email;

    public Valideur(String name, String prenom, String email) {
        this.name=name;
        this.prenom=prenom;
        this.email=email;
    }
}

