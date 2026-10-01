package br.com.petz.clientpet.pet.infra.repository;

import br.com.petz.clientpet.pet.domain.PetEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PetSpringDataJpaRepository extends JpaRepository<PetEntity, UUID> {
    Page<PetEntity> findAllByClient_ClientId(UUID clientId, Pageable pageable);
}
