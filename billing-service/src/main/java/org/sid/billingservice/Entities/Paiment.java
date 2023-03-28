package org.sid.billingservice.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paiment {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_commande ;
    private Long Id_client;
    private Long id_prouduit ;
    private int quantite ;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthday;
    @Transient
    private Client client;
    @Transient
    private Prouduit prouduit;
}
