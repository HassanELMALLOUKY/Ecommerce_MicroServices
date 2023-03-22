package org.sid.customerservice.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Customer {
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
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;
    @OneToOne
    private User user;


}
