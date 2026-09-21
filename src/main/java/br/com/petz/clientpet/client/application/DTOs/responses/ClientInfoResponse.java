package br.com.petz.clientpet.client.application.DTOs.responses;

import br.com.petz.clientpet.client.domain.Gender;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClientInfoResponse(
        UUID clientId,
        String fullName,
        String email,
        String cpf,
        String mobilePhoneNumber,
        String homePhoneNumber,
        Gender gender,
        Boolean agreesOnTermsAndConditions,
        LocalDateTime createdAt
) {
}
