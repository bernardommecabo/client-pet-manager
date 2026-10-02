package br.com.petz.clientpet.auth.user.application.service;

import br.com.petz.clientpet.auth.user.application.DTOs.request.UserRegisterRequest;
import br.com.petz.clientpet.auth.user.application.DTOs.response.UserRegisterResponse;
import br.com.petz.clientpet.auth.user.application.mapper.UserMapper;
import br.com.petz.clientpet.auth.user.domain.UserEntity;
import br.com.petz.clientpet.auth.user.domain.repository.UserRepository;
import br.com.petz.clientpet.client.domain.ClientEntity;
import br.com.petz.clientpet.client.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserApplicationService implements UserService {
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final UserMapper userMapper;

    @Override
    public UserRegisterResponse registerUser(UserRegisterRequest request) {
        log.info("[start] UserService - registerUser");

        ClientEntity client = clientRepository.findClient(request.clientId());

        UserEntity user = userRepository.saveUser(userMapper.toEntity(request,client));

        log.info("[finish] UserService - registerUser");
        return userMapper.toResponse(user);
    }

    @Override
    public UserRegisterResponse getUserById(UUID userId) {
        log.info("[start] UserController - getUserById");
        UserEntity user = userRepository.findById(userId);
        log.info("[finish] UserController - getUserById");
        return userMapper.toResponse(user);
    }
}
