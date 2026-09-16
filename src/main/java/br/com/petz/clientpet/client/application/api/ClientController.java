package br.com.petz.clientpet.client.application.api;

import br.com.petz.clientpet.client.application.DTOs.responses.ClientInfoResponse;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientListResponse;
import br.com.petz.clientpet.client.application.DTOs.requests.ClientRequest;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientResponse;
import br.com.petz.clientpet.client.application.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ClientController implements ClientAPI {
    private final ClientService clientService;

    @Override
    public ClientResponse postClient(ClientRequest request) {
        log.info("[start] ClientController - createClient");
        ClientResponse response = clientService.createClient(request);
        log.info("[finish] ClientController - createClient");
        return response;
    }

    @Override
    public ClientInfoResponse getClient(UUID clientId) {
        log.info("[start] ClientController - getClient");
        ClientInfoResponse response = clientService.getClientInfo(clientId);
        log.info("[finish] ClientController - getClient");
        return response;
    }

    @Override
    public List<ClientListResponse> getAllClients() {
        log.info("[start] ClientController - getAllClients");
        List<ClientListResponse> responses = clientService.getAllClients();
        log.info("[finish] ClientController - getAllClients");
        return responses;
    }
}
