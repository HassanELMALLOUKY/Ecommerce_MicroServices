package org.sid.customerservice.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
public class Customer implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fistName;
    private String lastName;
    //@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthday;
    @Column(nullable = false)
    private String phoneNumber;
    @OneToOne()
    private Address addresse;
    @OneToOne
    private User user;
    public Customer(){}
    public Customer(Long id, String fistName, String lastName, LocalDate birthday, String phoneNumber, Address addresse, User user) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.addresse = addresse;
        this.user = user;
    }
}
