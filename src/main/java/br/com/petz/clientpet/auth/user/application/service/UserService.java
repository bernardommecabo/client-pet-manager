package br.com.petz.clientpet.auth.user.application.service;

import br.com.petz.clientpet.auth.user.application.DTOs.request.UserRegisterRequest;
import br.com.petz.clientpet.auth.user.application.DTOs.response.UserRegisterResponse;

import java.util.UUID;

public interface UserService {
    UserRegisterResponse registerUser(UserRegisterRequest request);

    UserRegisterResponse getUserById(UUID userId);
}
