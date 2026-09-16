package br.com.petz.clientpet.client.application.service;

import br.com.petz.clientpet.client.application.DTOs.responses.ClientInfoResponse;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientListResponse;
import br.com.petz.clientpet.client.application.DTOs.requests.ClientRequest;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientResponse;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    ClientResponse createClient(ClientRequest request);
    List<ClientListResponse> getAllClients();
    ClientInfoResponse getClientInfo(UUID clientId);
    void deleteClientEntity(UUID clientId);
}
