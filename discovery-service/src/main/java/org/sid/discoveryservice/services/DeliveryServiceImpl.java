package org.sid.discoveryservice.services;

import org.sid.discoveryservice.entities.Delivery;
import org.sid.discoveryservice.entities.dto.DeliveryDto;
import org.sid.discoveryservice.entities.mappers.DeliveryMapper;
import org.sid.discoveryservice.repositories.DeliveryRepository;

import java.util.ArrayList;
import java.util.List;

public class DeliveryServiceImpl implements IDeliveryService{
    private DeliveryRepository deliveryRepository;
    private DeliveryMapper deliveryMapper;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, DeliveryMapper deliveryMapper) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryMapper = deliveryMapper;
    }

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public DeliveryDto getDelivery(Long id) {
        return deliveryMapper.toDTO(deliveryRepository.findById(id).get());
    }

    @Override
    public DeliveryDto saveDelivery(DeliveryDto deliveryDto) {
        Delivery delivery=deliveryMapper.toEntity(deliveryDto);
        return deliveryMapper.toDTO(deliveryRepository.save(delivery));
    }

    @Override
    public List<DeliveryDto> getAllDeliveries() {
        List<DeliveryDto> deliveries=new ArrayList<>();
        deliveryRepository.findAll().stream().map(delivery -> deliveries.add(deliveryMapper.toDTO(delivery)));
        return deliveries;
    }
}
