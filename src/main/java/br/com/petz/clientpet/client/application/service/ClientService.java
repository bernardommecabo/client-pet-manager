package br.com.petz.clientpet.client.application.service;

import br.com.petz.clientpet.client.application.DTOs.ClientListResponse;
import br.com.petz.clientpet.client.application.DTOs.ClientRequest;
import br.com.petz.clientpet.client.application.DTOs.ClientResponse;

import java.util.List;

public interface ClientService {
    ClientResponse createClient(ClientRequest request);
    List<ClientListResponse> getAllClients();
}
