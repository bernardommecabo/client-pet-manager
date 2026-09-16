package br.com.petz.clientpet.client.infra.repository;

import br.com.petz.clientpet.client.domain.ClientEntity;
import br.com.petz.clientpet.client.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
