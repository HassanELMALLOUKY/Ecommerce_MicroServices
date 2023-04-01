package org.sid.billingservice.web;
import lombok.AllArgsConstructor;
import org.sid.billingservice.DTO.PaiementRequest;
import org.sid.billingservice.DTO.PaiementResponse;
import org.sid.billingservice.Entities.Client;
import org.sid.billingservice.Entities.Paiment;
import org.sid.billingservice.Entities.Prouduit;
import org.sid.billingservice.openFeing.ClientRestService;
import org.sid.billingservice.openFeing.ProuduitRestService;
import org.sid.billingservice.services.ServicePaiementImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ServicePaiment")
public class Conttoller {
   @Autowired
    ProuduitRestService prouduitRestService ;
   ClientRestService clientRestService;
    ServicePaiementImpl paiementService ;

    @GetMapping("/GetProduits")
    public List<Prouduit> Produits(){

        return prouduitRestService.getProduits();
    }

    @GetMapping("/GetClients")
    public List<Client> clients(){
        return clientRestService.gettClients();
    }

    @GetMapping("/GetPaiements")
    public List<PaiementResponse> getPaiements(){
       return paiementService.getPaiements();
    }

    @GetMapping("/GetPaiement/{id}")
    public PaiementResponse getPaiement(@PathVariable(name = "id") Long id){
        return paiementService.getPaiement(id);
    }

    @PostMapping(path = "/AjouterPaiemnt")
    public PaiementResponse savePaiement(@RequestBody PaiementRequest paiementRequest){
        return  paiementService.savePaiement(paiementRequest);
    }

    @PutMapping(path = "updatePaiement/{idP}")
    public PaiementResponse updatePaiement(@PathVariable(name = "idP") Long id,
                                           @RequestBody Paiment paiment){
        paiment.setId_commande(id);
        return  paiementService.updatePaiement(paiment);
    }

    @DeleteMapping("/deletePaiement/{id}")
    public  void deleteFacture(@PathVariable(name = "id") long id){

        paiementService.deletePaiement(id);
    }

}
