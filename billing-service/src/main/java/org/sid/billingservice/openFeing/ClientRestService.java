package org.sid.billingservice.openFeing;

import org.sid.billingservice.Entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface ClientRestService {
    @GetMapping(path = "/api/customer/{id}")
    Client getClient(@PathVariable(name = "id") Long id);

    @GetMapping(path = "/api/customer/all")
    List<Client> gettClients ();

}
