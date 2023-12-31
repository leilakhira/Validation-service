package com.example.validation_service.Service;

import com.example.validation_service.Entite.Benevole;
import com.example.validation_service.Entite.Demande;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

@FeignClient(name ="BENEVOLE-SERVICE")
public interface BenevoleRestClient {
        @GetMapping(path = "benevoles/{id}")
        Benevole findBenevoleById(@PathVariable Long id);
        @PostMapping(path = "benevoles")
        @Produces(MediaType.APPLICATION_JSON)
        Benevole createBenevole(@RequestBody Benevole benevole);
        @GetMapping(path = "benevoles")
        @Produces(MediaType.APPLICATION_JSON)
        PagedModel<Benevole> findAll(@SpringQueryMap Pageable pageRequest);

        @DeleteMapping(path = "/benevoles/{id}")
        Benevole deleteById(@PathVariable Long id);
}