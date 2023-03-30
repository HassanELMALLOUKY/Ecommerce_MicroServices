package org.sid.customerservice.controllers;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.entities.dto.CustomerDTO;
import org.sid.customerservice.entities.mappers.CustomerMapper;
import org.sid.customerservice.services.Impl1.CustomerService;
import org.sid.customerservice.services.fakeData.FakerDataService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("/api/customer")
@RestController
public class CustomerControllerImpl implements ICustomerController{
    private CustomerService customerService;
    private FakerDataService fakerDataService;
    private CustomerMapper customerMapper;

    public CustomerControllerImpl(CustomerService customerService, FakerDataService fakerDataService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.fakerDataService = fakerDataService;
        this.customerMapper = customerMapper;
    }
    @GetMapping("/generate/{count}")
    @Override
    public @ResponseBody List<CustomerDTO> generatedata(@PathVariable int count) {
        fakerDataService.createCustomers(count);
        List<CustomerDTO> customerDTOList=new ArrayList<>();
        customerService.getAllCustomer().forEach(customer -> {
            customerDTOList.add(customerMapper.toDTO(customer));
        });
        return customerDTOList;
    }
    @GetMapping("/getCustomer/{id}")
    @Override
    public CustomerDTO getCustomer(Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/getAllCustomers")
    @Override
    public @ResponseBody List<Customer> getAllCustomers() {
        return customerService.getAllCustomer();
    }
    @PostMapping("")
    @Override
    public @ResponseBody CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.createCustomer(customerDTO);
        return customerDTO;
    }
    @PutMapping("/{id}")
    @Override
    public @ResponseBody CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customer) {
        return customerService.updateCustomer(id,customer);
    }
    @DeleteMapping("/{id}")
    @Override
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
