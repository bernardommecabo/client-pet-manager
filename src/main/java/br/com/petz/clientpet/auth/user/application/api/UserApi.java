package br.com.petz.clientpet.auth.user.application.api;

import br.com.petz.clientpet.auth.user.application.DTOs.request.UserRegisterRequest;
import br.com.petz.clientpet.auth.user.application.DTOs.response.UserRegisterResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/public/user")
public interface UserApi {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserRegisterResponse registerUser(@Valid @RequestBody UserRegisterRequest request);

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    UserRegisterResponse getUserByUserId(@PathVariable UUID userId);
}
