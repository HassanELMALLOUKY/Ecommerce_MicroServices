package org.sid.discoveryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.discoveryservice.entities.enumeration.DeliveryStatus;
import org.sid.discoveryservice.entities.models.Product;

import javax.persistence.*;

@Entity
@Table(name = "deliveries")
@Data @NoArgsConstructor @AllArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private DeliveryStatus status;

    private Long productId;
}

