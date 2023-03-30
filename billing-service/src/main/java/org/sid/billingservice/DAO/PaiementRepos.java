package org.sid.billingservice.DAO;

import org.sid.billingservice.Entities.Paiment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaiementRepos extends JpaRepository<Paiment,Long> {
}
