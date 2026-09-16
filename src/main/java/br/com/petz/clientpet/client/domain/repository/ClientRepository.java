package br.com.petz.clientpet.client.domain.repository;

import br.com.petz.clientpet.client.domain.ClientEntity;

import java.util.List;
import java.util.UUID;

public interface ClientRepository {
    ClientEntity saveClient(ClientEntity client);
    List<ClientEntity> findAllClients();
    ClientEntity findClient(UUID clientId);
}
