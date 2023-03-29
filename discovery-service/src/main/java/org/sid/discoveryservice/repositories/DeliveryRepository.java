package org.sid.discoveryservice.repositories;

import org.sid.discoveryservice.entities.Delivery;
import org.sid.discoveryservice.entities.enumeration.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
}
