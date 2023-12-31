package com.example.validation_service.Service;

import com.example.validation_service.Entite.Demande;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

@FeignClient(name ="DEMANDE-SERVICE")
public interface DemandeRestClient {
    @GetMapping(path = "demandes/{id}")
    Demande findDemandeById(@PathVariable Long id);
    @GetMapping(path = "demandes")
    @Produces(MediaType.APPLICATION_JSON)
    PagedModel<Demande> findAll(@SpringQueryMap Pageable pageRequest);
    @PostMapping(path = "demandes")
    @Produces(MediaType.APPLICATION_JSON)
    Demande createDemande(@RequestBody Demande demande);
    @DeleteMapping(path = "/demandes/{id}")
    Demande deleteById(@PathVariable Long id);

}
