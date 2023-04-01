package org.sid.billingservice.Entities;


import lombok.Data;

@Data
public class Prouduit {
    private Long id_produit ;
    private String name ;
    private int Quantite_stock ;
    private  double prix ;
    private String categorie;
    private String description ;
    private  String image ;
}
