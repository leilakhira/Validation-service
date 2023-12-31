package com.example.validation_service.Entite;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Benevole{
    private Long benevole_id;
    private String name;
    private String prenom;
    private int age;
    private String tele;
    private String adresse;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateofDispo;

    public Benevole(String name, String prenom, int age, String tele, String adresse, Date dateofDispo) {
        this.name = name;
        this.prenom = prenom;
        this.age = age;
        this.tele = tele;
        this.adresse = adresse;
        this.dateofDispo = dateofDispo;
    }
}

