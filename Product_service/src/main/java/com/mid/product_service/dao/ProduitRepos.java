package com.mid.product_service.dao;

import com.mid.product_service.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepos extends JpaRepository<Produit,Long> {

}
