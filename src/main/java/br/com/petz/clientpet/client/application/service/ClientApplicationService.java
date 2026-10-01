package br.com.petz.clientpet.client.application.service;

import br.com.petz.clientpet.client.application.DTOs.requests.ClientUpdateRequest;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientInfoResponse;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientListResponse;
import br.com.petz.clientpet.client.application.DTOs.requests.ClientRequest;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientResponse;
import br.com.petz.clientpet.client.application.mapper.ClientMapper;
import br.com.petz.clientpet.client.domain.ClientEntity;
import br.com.petz.clientpet.client.domain.repository.ClientRepository;
import br.com.petz.clientpet.utils.DTOs.PageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClientApplicationService implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientResponse createClient(ClientRequest request) {
        log.info("[start] ClientService - createClient");
        ClientEntity client = clientRepository.saveClient(clientMapper.toEntity(request));
        log.info("[finish] ClientService - createClient");
        return clientMapper.toResponse(client);
    }

    @Override
    public ClientInfoResponse getClientInfo(UUID clientId) {
        log.info("[start] ClientService - getClientInfo");
        ClientEntity client = clientRepository.findClient(clientId);
        log.info("[finish] ClientService - getClientInfo");
        return clientMapper.toInfoResponse(client);
    }

    @Override
    public PageResponse<ClientListResponse> getAllClients(Pageable pageable) {
        log.info("[start] ClientService - getClientsList");

        Page<ClientEntity> clients = clientRepository.findAllClients(pageable);
        Page<ClientListResponse> response = clients.map(clientMapper::toListResponse);

        log.info("[finish] ClientService - getClientsList");
        return PageResponse.from(response);
    }

    @Override
    public void updateClient(UUID clientId, ClientUpdateRequest request) {
        log.info("[start] ClientService - updateClient");
        ClientEntity client = clientRepository.findClient(clientId);
        clientMapper.updateEntityFromRequest(request, client);
        clientRepository.saveClient(client);
        log.info("[finish] ClientService - updateClient");
    }

    @Override
    public void deleteClientEntity(UUID clientId) {
        log.info("[start] ClientService - deleteClientEntity");
        ClientEntity client = clientRepository.findClient(clientId);
        clientRepository.deleteClient(client.getClientId());
        log.info("[finish] ClientService - deleteClientEntity");
    }
}
