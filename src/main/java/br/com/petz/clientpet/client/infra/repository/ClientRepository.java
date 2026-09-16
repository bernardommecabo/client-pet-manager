package br.com.petz.clientpet.client.infra.repository;

import br.com.petz.clientpet.client.domain.ClientEntity;

public interface ClientRepository {
    ClientEntity saveClient(ClientEntity clientEntity);
}
