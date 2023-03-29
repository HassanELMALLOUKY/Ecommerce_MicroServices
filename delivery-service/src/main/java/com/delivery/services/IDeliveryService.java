package com.delivery.services;


import com.delivery.entities.dto.DeliveryDto;

import java.util.List;

public interface IDeliveryService {
    DeliveryDto getDelivery(Long id);
    DeliveryDto saveDelivery(DeliveryDto deliveryDto);
    List<DeliveryDto> getAllDeliveries();
}
