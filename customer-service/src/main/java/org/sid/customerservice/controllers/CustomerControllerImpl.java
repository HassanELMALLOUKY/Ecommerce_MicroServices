package org.sid.customerservice.controllers;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.services.Impl1.CustomerService;
import org.sid.customerservice.services.fakeData.FakerDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CustomerControllerImpl implements ICustomerController{
    private CustomerService customerService;
    private FakerDataService fakerDataService;

    public CustomerControllerImpl(CustomerService customerService, FakerDataService fakerDataService) {
        this.customerService = customerService;
        this.fakerDataService = fakerDataService;
    }
    @GetMapping("/api/generate/{count}")
    @Override
    public List<Customer> generatedata(@PathVariable int count) {
        fakerDataService.createCustomers(count);
        return customerService.getAllCustomer();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }
}
