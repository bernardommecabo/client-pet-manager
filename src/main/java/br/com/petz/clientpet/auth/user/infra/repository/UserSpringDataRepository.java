package br.com.petz.clientpet.auth.user.infra.repository;

import br.com.petz.clientpet.auth.user.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserSpringDataRepository extends JpaRepository<UserEntity, UUID> {
    boolean existsByClient_ClientId(UUID clientId);
}
