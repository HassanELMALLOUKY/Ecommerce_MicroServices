package com.mid.product_service.services;

import com.mid.product_service.dao.ProduitRepos;
import com.mid.product_service.dto.DtoProduitRequest;
import com.mid.product_service.dto.DtoProduitResponse;
import com.mid.product_service.entities.Produit;
import com.mid.product_service.mappers.ProduitMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProduitServiceImpl implements ProduitService{
    ProduitRepos produitRepos;
    ProduitMapper produitMapper;
    @Override
    public DtoProduitResponse getProduit(Long id) {
        Produit produit=produitRepos.findById(id).orElse(null);
        DtoProduitResponse dtoProduitResponse= produitMapper.ProduitRes(produit);
        return dtoProduitResponse;
    }

    @Override
    public List<DtoProduitResponse> getProduits() {
        List<Produit> produits=produitRepos.findAll();
        List<DtoProduitResponse> produitResponses=produits.stream().map(produit ->
        produitMapper.ProduitRes(produit)).collect(Collectors.toList());
        return produitResponses;
    }

    @Override
    public DtoProduitResponse SaveProduit(DtoProduitRequest produitRequest) {
        Produit produit=produitRepos.save(produitMapper.fromProduitDtoReq(produitRequest));
        DtoProduitResponse dtoProduitResponse=produitMapper.ProduitRes(produit);
        return dtoProduitResponse;
    }

    @Override
    public DtoProduitResponse updateProduit(Produit produit) {
        Produit produitUpdate=produitRepos.save(produit);
        DtoProduitResponse dtoProduitResponse=produitMapper.ProduitRes(produitUpdate);
        return dtoProduitResponse;
    }

    @Override
    public DtoProduitResponse updateQauntiteStock(Produit produit) {
        Produit produitUpdate=produitRepos.save(produit);
        DtoProduitResponse dtoProduitResponse=produitMapper.ProduitRes(produitUpdate);
        return dtoProduitResponse;
    }

    @Override
    public void deleteProduit(Long id) {
        produitRepos.deleteById(id);

    }
}
