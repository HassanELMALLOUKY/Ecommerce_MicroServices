package org.sid.customerservice.services.fakeData;

import com.github.javafaker.Faker;
import org.sid.customerservice.entities.Address;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.entities.User;
import org.sid.customerservice.repository.AddressRepository;
import org.sid.customerservice.repository.CustomerRepository;
import org.sid.customerservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class FakerDataService {
    private CustomerRepository customerRepository;
    private UserRepository userRepository;
    private AddressRepository addressRepository;
    private Faker faker;
    public FakerDataService(CustomerRepository customerRepository, UserRepository userRepository, AddressRepository addressRepository, Faker faker) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.faker = faker;
    }


    public void createCustomers(int count) {
        for (int i = 0; i < count; i++) {
            User user=userRepository.save(new User(faker.name().username(),faker.internet().emailAddress(),faker.internet().password()));
            Address address=addressRepository.save(new Address(faker.address().streetAddress(),faker.address().city(), faker.address().state(),faker.address().zipCode()));

            Customer customer=customerRepository.save(new Customer(null,faker.name().firstName(),faker.name().lastName(),faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),faker.phoneNumber().phoneNumber(), address,user));
        }
    }
}
