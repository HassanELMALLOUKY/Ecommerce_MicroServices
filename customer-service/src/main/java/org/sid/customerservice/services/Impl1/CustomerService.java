package org.sid.customerservice.services.Impl1;

import org.apache.http.client.HttpResponseException;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.sid.customerservice.services.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id,Customer customer) {
        Customer customer1=customerRepository.findById(id).orElse(null);
        /*customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());*/
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
      customerRepository.deleteById(id);
    }
}
