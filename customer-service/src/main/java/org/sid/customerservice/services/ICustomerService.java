package org.sid.customerservice.services;

import org.sid.customerservice.entities.Customer;

import java.util.List;

public interface ICustomerService {
    Customer getCustomer(Long id);
    List<Customer> getAllCustomer();
    Customer updateCustomer(Long id,Customer customer);
    void deleteCustomer(Long id);
}
