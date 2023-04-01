package org.sid.billingservice.services;

import lombok.AllArgsConstructor;
import org.sid.billingservice.DAO.PaiementRepos;
import org.sid.billingservice.DTO.PaiementRequest;
import org.sid.billingservice.DTO.PaiementResponse;
import org.sid.billingservice.Entities.Client;
import org.sid.billingservice.Entities.Paiment;
import org.sid.billingservice.Entities.Prouduit;
import org.sid.billingservice.mappers.PaiementMappers;
import org.sid.billingservice.openFeing.ClientRestService;
import org.sid.billingservice.openFeing.ProuduitRestService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Transactional
@Service
public class ServicePaiementImpl implements  PaiementService {
    PaiementMappers paiementMappers ;
    PaiementRepos paiementRepos ;
    ProuduitRestService prouduitRestService;
    ClientRestService clientRestService;

    @Override
    public List<PaiementResponse> getPaiements() {
        List<Paiment> paiments=paiementRepos.findAll();
        List<Prouduit> prouduits=prouduitRestService.getProduits() ;
        List<Client> clients=clientRestService.gettClients();
        for (int i=0 ; i<paiments.size();i++){
            for(int j=0 ; j<prouduits.size(); j++) {
                if(prouduits.get(j).getId_produit()==paiments.get(i).getId_prouduit())
                    paiments.get(i).setProuduit(prouduits.get(j));
            }

            for(int k=0 ; k<clients.size(); k++) {
                if(clients.get(k).getId()==paiments.get(i).getId_client())
                    paiments.get(i).setClient(clients.get(k));
            }
        }
        List<PaiementResponse> paiementResponseList =paiments.stream().map(paiment ->
                paiementMappers.paimentResFromPaiement(paiment) ).collect(Collectors.toList());
        return  paiementResponseList;
    }

    @Override
    public PaiementResponse getPaiement(Long id) {

        Paiment paiment=paiementRepos.findById(id).orElse(null);
        Prouduit prouduit =prouduitRestService.getProuduit(paiment.getId_prouduit());
        Client client =clientRestService.getClient(paiment.getId_client());
       paiment.setProuduit(prouduit);
       paiment.setClient(client);
        PaiementResponse paiementResponse = paiementMappers.paimentResFromPaiement(paiment);

        return paiementResponse;
    }

    @Override
    public PaiementResponse savePaiement(PaiementRequest paiementRequest) {
        Prouduit prouduit =prouduitRestService.getProuduit(paiementRequest.getId_prouduit());
        Paiment paiment=paiementMappers.PaiemntFromRequest(paiementRequest);
        if(prouduit!=null && prouduit.getQuantite_stock()>=paiment.getQuantite()){
            prouduit.setQuantite_stock(prouduit.getQuantite_stock()-paiment.getQuantite());
            Prouduit prouduit1=prouduitRestService.updateStock(prouduit);
            paiment.setPrixTotale(paiment.getQuantite()*prouduit.getPrix());
            paiment.setBirthday(new Date());
            paiementRepos.save(paiment);
            paiment.setProuduit(prouduit1);
            paiment.setClient(clientRestService.getClient(paiementRequest.getId_client()));
        }

        PaiementResponse paiementResponse=paiementMappers.paimentResFromPaiement(paiment);

        return paiementResponse;
    }

    @Override
    public PaiementResponse updatePaiement(Paiment paiment) {
        Prouduit prouduit =prouduitRestService.getProuduit(paiment.getId_prouduit());
        if(prouduit!=null){
            paiment.setPrixTotale(paiment.getQuantite()*prouduit.getPrix());
            paiment.setBirthday(new Date());
            paiementRepos.save(paiment);
        }
        paiment.setProuduit(prouduit);
        paiment.setClient(clientRestService.getClient(paiment.getId_client()));
        PaiementResponse paiementResponse=paiementMappers.paimentResFromPaiement(paiment);

        return paiementResponse;
    }

    @Override
    public void deletePaiement(Long id) {
paiementRepos.deleteById(id);
    }
}
