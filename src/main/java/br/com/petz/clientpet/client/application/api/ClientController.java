package br.com.petz.clientpet.client.application.api;

import br.com.petz.clientpet.client.application.DTOs.ClientRequest;
import br.com.petz.clientpet.client.application.DTOs.ClientResponse;
import br.com.petz.clientpet.client.application.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}
