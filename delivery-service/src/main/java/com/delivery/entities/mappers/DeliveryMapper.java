package com.delivery.entities.mappers;

import com.delivery.entities.Delivery;
import com.delivery.entities.dto.DeliveryDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
@Service
public interface DeliveryMapper {
    DeliveryDto toDTO(Delivery delivery);
    Delivery toEntity(DeliveryDto customerDTO);
}
