package org.sid.billingservice.Entities;

import lombok.Data;

@Data
public class Adress {
    private String street;

    private String city;

    private String state;

    private String postalCode;
}
