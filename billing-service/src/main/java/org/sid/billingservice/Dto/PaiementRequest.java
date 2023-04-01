package org.sid.billingservice.DTO;

import lombok.Data;



@Data
public class PaiementRequest {
    private Long Id_client;
    private Long id_prouduit ;
    private int quantite ;
}
