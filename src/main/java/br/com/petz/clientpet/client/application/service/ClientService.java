package br.com.petz.clientpet.client.application.service;

import br.com.petz.clientpet.client.application.DTOs.requests.ClientUpdateRequest;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientInfoResponse;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientListResponse;
import br.com.petz.clientpet.client.application.DTOs.requests.ClientRequest;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientResponse;
import br.com.petz.clientpet.utils.DTOs.PageResponse;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ClientService {
    ClientResponse createClient(ClientRequest request);
    PageResponse<ClientListResponse> getAllClients(Pageable pageable);
    ClientInfoResponse getClientInfo(UUID clientId);
    void updateClient(UUID clientId, ClientUpdateRequest request);
    void deleteClientEntity(UUID clientId);
}
