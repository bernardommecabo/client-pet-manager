package br.com.petz.clientpet.auth.user.infra.repository;

import br.com.petz.clientpet.auth.user.domain.UserEntity;
import br.com.petz.clientpet.auth.user.domain.repository.UserRepository;
import br.com.petz.clientpet.handlers.exceptions.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class UserInfraRepository implements UserRepository {
    private final UserSpringDataRepository repository;
    @Override
    public UserEntity saveUser(UserEntity user) {
        log.info("[start] UserRepository - saveUser");
        UserEntity savedUser = repository.save(user);
        log.info("[finish] UserRepository - saveUser");
        return savedUser;
    }

    @Override
    public UserEntity findById(UUID userId) {
        log.info("[start] UserRepository - findById");
        UserEntity savedUser = repository.findById(userId)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "User not found"));
        log.info("[finish] UserRepository - findById");
        return savedUser;
    }
}
