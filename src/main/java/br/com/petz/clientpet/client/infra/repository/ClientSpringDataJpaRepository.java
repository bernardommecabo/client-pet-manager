package br.com.petz.clientpet.client.infra.repository;

import br.com.petz.clientpet.client.domain.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientSpringDataJpaRepository extends JpaRepository<ClientEntity, UUID> {
}
