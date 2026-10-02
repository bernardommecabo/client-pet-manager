package br.com.petz.clientpet.auth.user.application.api;

import br.com.petz.clientpet.auth.user.application.DTOs.request.UserRegisterRequest;
import br.com.petz.clientpet.auth.user.application.DTOs.response.UserRegisterResponse;
import br.com.petz.clientpet.auth.user.application.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class UserController implements UserApi {
    private final UserService userService;

    @Override
    public UserRegisterResponse registerUser(UserRegisterRequest request) {
        log.info("[start] - UserController - registerUser");
        UserRegisterResponse response = userService.registerUser(request);
        log.info("[finish] - UserController - registerUser");
        return response;
    }

    @Override
    public UserRegisterResponse getUserByUserId(UUID userId) {
        log.info("[start] - UserController - getUser");
        UserRegisterResponse response = userService.getUserById(userId);
        log.info("[finish] - UserController - getUser");
        return response;
    }
}
