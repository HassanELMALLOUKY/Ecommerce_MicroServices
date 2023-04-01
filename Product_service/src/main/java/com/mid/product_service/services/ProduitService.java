package com.mid.product_service.services;

import com.mid.product_service.dto.DtoProduitRequest;
import com.mid.product_service.dto.DtoProduitResponse;
import com.mid.product_service.entities.Produit;

import java.util.List;

public interface ProduitService {
    DtoProduitResponse getProduit(Long id);
    List<DtoProduitResponse> getProduits();
    DtoProduitResponse SaveProduit(DtoProduitRequest produitRequest);
    DtoProduitResponse updateProduit(Produit produit);
    DtoProduitResponse updateQauntiteStock(Produit produit);
    void deleteProduit(Long id);

}
