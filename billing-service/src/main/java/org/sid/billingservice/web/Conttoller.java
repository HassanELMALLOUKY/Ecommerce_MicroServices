package org.sid.billingservice.web;


import lombok.AllArgsConstructor;
import org.sid.billingservice.Entities.Prouduit;
import org.sid.billingservice.openFeing.ProuduitRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ServicePaiment")
public class Conttoller {
   @Autowired
    ProuduitRestService prouduitRestService ;
    @GetMapping("/GetProduits")
    public List<Prouduit> Produits(){

        return prouduitRestService.getProduits();
    }

}
