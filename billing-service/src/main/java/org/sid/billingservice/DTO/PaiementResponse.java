package org.sid.billingservice.DTO;

import lombok.Data;
import org.sid.billingservice.Entities.Client;
import org.sid.billingservice.Entities.Prouduit;
import java.util.Date;

@Data
public class PaiementResponse {
    private Long Id_commande ;
    private Long Id_client;
    private Long id_prouduit ;
    private int quantite ;
    private  double prixTotale;
    private Date birthday;
    private Client client;
    private Prouduit prouduit;
}
