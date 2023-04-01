package org.sid.billingservice.Entities;


import lombok.Data;


@Data
public class Client {
    private Long id;
    private String fistName;
    private String lastName;
    private String phoneNumber;
     private User user ;
   // private String email ;

}
