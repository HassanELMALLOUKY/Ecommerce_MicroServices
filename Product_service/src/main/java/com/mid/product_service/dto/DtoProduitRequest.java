package com.mid.product_service.dto;

import lombok.Data;

@Data
public class DtoProduitRequest {
    private String name ;
    private String description ;
    private int Quantite_stock ;
    private  double prix ;
    private  String image ;
    private  String categorie ;
}
