package com.mid.product_service.web;


import com.mid.product_service.dto.DtoProduitRequest;
import com.mid.product_service.dto.DtoProduitResponse;
import com.mid.product_service.entities.Produit;
import com.mid.product_service.services.ProduitService;
import com.mid.product_service.services.ProduitServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ServiceProduit")
public class ProduitController {


    private ProduitServiceImpl produitService;
    //public controller(ClientServiceImpl clientService) {this.clientService = clientService;}

    @GetMapping("/GetProduits")
    public List<DtoProduitResponse> Produits(){

        return produitService.getProduits();
    }

    @GetMapping("GetProduit/{id}")
    public  DtoProduitResponse Produit(@PathVariable(name = "id") Long id ) {

        return produitService.getProduit(id);
    }

    @PostMapping("/AjouterProduit")
    public DtoProduitResponse AjouterProduit(@RequestBody DtoProduitRequest produitRequest){
        return  produitService.SaveProduit(produitRequest);
    }

    @PutMapping("/updateProduit/{id}")
    public DtoProduitResponse UpdateProduit(@PathVariable(name = "id") Long id, @RequestBody Produit produit){
        produit.setId_produit(id);
        return  produitService.updateProduit(produit);
    }

    @DeleteMapping("deleteProduit/{id}")
    public  void deleteProduit(@PathVariable(name = "id") Long id ){

     produitService.deleteProduit(id);
    }

}
