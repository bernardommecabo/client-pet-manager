package br.com.petz.clientpet.client.application.DTOs;

import java.util.UUID;

public record ClientListResponse(
        UUID clientId,
        String fullName,
        String email,
        String cpf,
        String mobilePhoneNumber
) {
}
