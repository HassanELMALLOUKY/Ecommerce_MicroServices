package org.sid.discoveryservice.entities.mappers;

import org.mapstruct.Mapper;
import org.sid.discoveryservice.entities.Delivery;
import org.sid.discoveryservice.entities.dto.DeliveryDto;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
@Service
public interface DeliveryMapper {
    DeliveryDto toDTO(Delivery customer);
    Delivery toEntity(DeliveryDto customerDTO);
}
