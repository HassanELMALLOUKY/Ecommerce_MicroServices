package org.sid.customerservice.services.Impl1;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.entities.dto.CustomerDTO;
import org.sid.customerservice.entities.mappers.CustomerMapper;
import org.sid.customerservice.entities.mappers.Mapper;
import org.sid.customerservice.repository.CustomerRepository;
import org.sid.customerservice.services.ICustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CustomerService implements ICustomerService {
    private CustomerRepository customerRepository;
    private Mapper mapper;

    public CustomerService(CustomerRepository customerRepository, Mapper mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    @Override
    public CustomerDTO getCustomer(Long id) {
        Customer customer=customerRepository.findById(id).orElse(null);

        return mapper.toDto(customer) ;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer=mapper.toEntity(customerDTO);
        customerRepository.save(customer);
        return  mapper.toDto(customer);

    }

    @Override
    public CustomerDTO updateCustomer(Long id,CustomerDTO customerDTO) {
        Customer customer=mapper.toEntity(customerDTO);
        customerRepository.save(customer);
        return mapper.toDto(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
      customerRepository.deleteById(id);
    }
}
