package org.sid.billingservice.openFeing;

import org.sid.billingservice.Entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientRestService {
    @GetMapping(path = "/api/ServiceClient/GetClient/{id}")
    Client getClient(@PathVariable(name = "id") Long id);

    @GetMapping(path = "/api/ServiceClient/GetClients")
    List<Client> gettClients ();

}
