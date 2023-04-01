package org.sid.billingservice.services;

import org.sid.billingservice.DTO.PaiementRequest;
import org.sid.billingservice.DTO.PaiementResponse;

import org.sid.billingservice.Entities.Paiment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementService {
    List<PaiementResponse>  getPaiements();
    PaiementResponse getPaiement(Long id);
    PaiementResponse savePaiement(PaiementRequest paiementRequest);
    PaiementResponse updatePaiement(Paiment paiment);
    void deletePaiement(Long id);


}
