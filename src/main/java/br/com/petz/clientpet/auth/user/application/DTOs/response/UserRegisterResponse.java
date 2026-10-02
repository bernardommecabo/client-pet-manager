package br.com.petz.clientpet.auth.user.application.DTOs.response;

import java.util.UUID;

public record UserRegisterResponse(
        UUID userId,
        String email,
        UUID clientId
) {
}
