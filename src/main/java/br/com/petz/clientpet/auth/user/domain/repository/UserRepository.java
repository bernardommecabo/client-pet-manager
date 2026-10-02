package br.com.petz.clientpet.auth.user.domain.repository;

import br.com.petz.clientpet.auth.user.domain.UserEntity;

import java.util.UUID;

public interface UserRepository {
    UserEntity saveUser(UserEntity user);

    UserEntity findById(UUID userId);
}
