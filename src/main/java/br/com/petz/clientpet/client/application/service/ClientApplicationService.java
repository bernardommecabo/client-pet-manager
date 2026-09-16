package br.com.petz.clientpet.client.application.service;

import br.com.petz.clientpet.client.application.DTOs.ClientRequest;
import br.com.petz.clientpet.client.application.DTOs.ClientResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ClientApplicationService implements ClientService {
    @Override
    public ClientResponse createClient(ClientRequest request) {
        log.info("[start] ClientService - createClient");
        log.info("[finish] ClientService - createClient");
        return null;
    }
}
