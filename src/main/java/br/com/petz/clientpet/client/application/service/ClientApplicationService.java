package br.com.petz.clientpet.client.application.service;

import br.com.petz.clientpet.client.application.DTOs.ClientListResponse;
import br.com.petz.clientpet.client.application.DTOs.ClientRequest;
import br.com.petz.clientpet.client.application.DTOs.ClientResponse;
import br.com.petz.clientpet.client.application.mapper.ClientMapper;
import br.com.petz.clientpet.client.domain.ClientEntity;
import br.com.petz.clientpet.client.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<ClientListResponse> getAllClients() {
        log.info("[start] ClientService - getClientsList");
        List<ClientEntity> clients = clientRepository.findAllClients();
        log.info("[finish] ClientService - getClientsList");
        return clients.stream()
                .map(clientMapper::toListResponse)
                .toList();
    }
}
