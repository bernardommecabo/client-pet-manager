package br.com.petz.clientpet.client.application.DTOs.requests;

import br.com.petz.clientpet.client.domain.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClientUpdateRequest(
        @NotBlank
        String fullName,

        @NotBlank
        String mobilePhoneNumber,

        String homePhoneNumber,
        Gender gender,

        @NotNull
        LocalDate birthDate,

        @NotNull
        Boolean agreesOnTermsAndConditions
) {
}
