package org.sid.discoveryservice.services;

import org.sid.discoveryservice.entities.Delivery;
import org.sid.discoveryservice.entities.dto.DeliveryDto;

import java.util.List;

public interface IDeliveryService {
    DeliveryDto getDelivery(Long id);
    DeliveryDto saveDelivery(DeliveryDto deliveryDto);
    List<DeliveryDto> getAllDeliveries();
}
