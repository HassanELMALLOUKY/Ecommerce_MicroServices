package org.sid.customerservice.controllers;

import org.sid.customerservice.entities.Customer;

import java.util.List;

public interface ICustomerController {
    List<Customer> generatedata(int count);
    List<Customer> getAllCustomers();
}
