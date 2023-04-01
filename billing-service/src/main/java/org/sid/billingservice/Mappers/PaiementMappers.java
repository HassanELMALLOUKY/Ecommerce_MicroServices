package org.sid.billingservice.mappers;

import org.sid.billingservice.DTO.PaiementRequest;
import org.sid.billingservice.DTO.PaiementResponse;
import org.sid.billingservice.Entities.Paiment;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
public class PaiementMappers {
    public PaiementResponse paimentResFromPaiement(Paiment paiment) {
        PaiementResponse paiementResponse = new PaiementResponse();
        BeanUtils.copyProperties(paiment, paiementResponse);
        return paiementResponse;
    }

    public Paiment PaiemntFromRequest(PaiementRequest paiementRequest) {
        Paiment paiment = new Paiment();
        BeanUtils.copyProperties(paiementRequest, paiment);
        return paiment;
    }

    public PaiementRequest PaiementRequestFromPaiemnet(Paiment paiment) {
        PaiementRequest paiementRequest = new PaiementRequest();
        BeanUtils.copyProperties(paiment, paiementRequest);
        return paiementRequest;
    }

    public Paiment paiementFromPaiementResponse(PaiementResponse paiementResponse) {
        Paiment paiment = new Paiment();
        BeanUtils.copyProperties(paiementResponse, paiment);
        return paiment;
    }
}
