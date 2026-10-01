package br.com.petz.clientpet.client.infra.repository;

import br.com.petz.clientpet.client.domain.ClientEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientSpringDataJpaRepository extends JpaRepository<ClientEntity, UUID> {
    @Override
    Page<ClientEntity> findAll(@NonNull Pageable pageable);
}
