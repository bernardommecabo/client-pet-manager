package br.com.petz.clientpet.client.infra.repository;

import br.com.petz.clientpet.client.domain.ClientEntity;
import br.com.petz.clientpet.client.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ClientInfraRepository implements ClientRepository {
    private final ClientSpringDataJpaRepository repository;

    @Override
    public ClientEntity saveClient(ClientEntity client) {
        log.info("[start] ClientRepository - saveClient");
        ClientEntity savedClient = repository.save(client);
        log.info("[finish] ClientRepository - saveClient");
        return savedClient;
    }

    @Override
    public List<ClientEntity> findAllClients() {
        log.info("[start] ClientRepository - findAllClients");
        List<ClientEntity> clientsList = repository.findAll();
        log.info("[finish] ClientRepository - findAllClients");
        return clientsList;
    }

    @Override
    public ClientEntity findClient(UUID clientId) {
        log.info("[start] ClientRepository - findClient");
        ClientEntity client = repository.findById(clientId).orElse(null);
        log.info("[finish] ClientRepository - findClient");
        return client;
    }
}
