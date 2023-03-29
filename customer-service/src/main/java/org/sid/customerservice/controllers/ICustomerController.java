package org.sid.customerservice.controllers;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.entities.dto.CustomerDTO;

import java.util.List;

public interface ICustomerController {
    List<CustomerDTO> generatedata(int count);
    CustomerDTO getCustomer(Long id);
    List<Customer> getAllCustomers();
    CustomerDTO createCustomer(CustomerDTO customer);
    CustomerDTO updateCustomer(Long id,CustomerDTO customerDTO);
    void deleteCustomer(Long id);
}
