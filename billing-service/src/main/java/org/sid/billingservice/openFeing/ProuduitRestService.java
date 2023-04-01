package org.sid.billingservice.openFeing;

import org.sid.billingservice.Entities.Client;
import org.sid.billingservice.Entities.Prouduit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@FeignClient(name = "PRODUIT-SERVICE")
public interface ProuduitRestService {
        @GetMapping(path = "/api/ServiceProduit/GetProduit/{id}")
        Prouduit getProuduit(@PathVariable(name = "id") Long id);

        @GetMapping(path = "/api/ServiceProduit//GetProduits")
        List<Prouduit> getProduits();

        @PutMapping (path = "/api/ServiceProduit//updateStock")
        Prouduit updateStock(@RequestBody Prouduit prouduit);

}