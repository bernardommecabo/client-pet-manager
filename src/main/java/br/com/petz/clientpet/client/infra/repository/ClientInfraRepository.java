package br.com.petz.clientpet.client.infra.repository;

import br.com.petz.clientpet.client.domain.ClientEntity;
import br.com.petz.clientpet.client.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
