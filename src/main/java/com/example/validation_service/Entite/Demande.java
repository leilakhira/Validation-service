package com.example.validation_service.Entite;
import com.example.validation_service.Enum.demande_status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class Demande {
    private Long Demande_id;
    private String name;
    private String prenom;
    private int age;
    private String tele;
    private String adresse;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Demande_date ;
    private String Description;
    @Enumerated(EnumType.STRING)
    private demande_status status ;
}
