package org.sid.customerservice.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.entities.dto.CustomerDTO;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );
    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);
}
