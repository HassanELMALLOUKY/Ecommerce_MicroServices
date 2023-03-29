package org.sid.customerservice.services;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.entities.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    CustomerDTO getCustomer(Long id);
    List<Customer> getAllCustomer();
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(Long id,CustomerDTO customer);
    void deleteCustomer(Long id);
}
