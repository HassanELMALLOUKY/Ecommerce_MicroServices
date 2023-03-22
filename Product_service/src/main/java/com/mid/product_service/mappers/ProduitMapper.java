package com.mid.product_service.mappers;

import com.mid.product_service.dto.DtoProduitRequest;
import com.mid.product_service.dto.DtoProduitResponse;
import com.mid.product_service.entities.Produit;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProduitMapper {

    public DtoProduitRequest ProduitReq(Produit produit) {
        DtoProduitRequest produitRequest = new DtoProduitRequest();
        BeanUtils.copyProperties(produit, produitRequest);


        return produitRequest;
    }

    public DtoProduitResponse ProduitRes(Produit produit) {
        DtoProduitResponse produitResponse = new DtoProduitResponse();
        BeanUtils.copyProperties(produit, produitResponse);
        return produitResponse;
    }

    public Produit fromProduitDtoRes(DtoProduitResponse produitResponse) {
        Produit produit = new Produit();
        BeanUtils.copyProperties(produitResponse, produit);
        return produit;
    }

    public Produit fromProduitDtoReq(DtoProduitRequest produitRequest) {
        Produit produit = new Produit();
        BeanUtils.copyProperties(produitRequest, produit);
        return produit;
    }
}
