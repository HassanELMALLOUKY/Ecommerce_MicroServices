package org.sid.customerservice.entities.mappers;

import org.mapstruct.Mapper;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.entities.dto.CustomerDTO;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
@Service
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);
}
