package br.com.petz.clientpet.client.domain.repository;

import br.com.petz.clientpet.client.domain.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ClientRepository {
    ClientEntity saveClient(ClientEntity client);
    Page<ClientEntity> findAllClients(Pageable pageable);
    ClientEntity findClient(UUID clientId);
    void deleteClient(UUID clientId);
}
