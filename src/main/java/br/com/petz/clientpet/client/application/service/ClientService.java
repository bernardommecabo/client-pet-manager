package br.com.petz.clientpet.client.application.service;

import br.com.petz.clientpet.client.application.DTOs.ClientRequest;
import br.com.petz.clientpet.client.application.DTOs.ClientResponse;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    ClientResponse createClient(ClientRequest request);
}
