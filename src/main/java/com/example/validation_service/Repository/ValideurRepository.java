package com.example.validation_service.Repository;

import com.example.validation_service.Entite.Valideur;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

@RepositoryRestResource
public interface ValideurRepository extends JpaRepository<Valideur,Long> {

}
