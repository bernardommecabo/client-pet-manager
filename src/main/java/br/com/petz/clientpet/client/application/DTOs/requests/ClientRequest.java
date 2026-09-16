package br.com.petz.clientpet.client.application.DTOs.requests;

import br.com.petz.clientpet.client.domain.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record ClientRequest(
        @NotBlank
        String fullName,

        @NotBlank
        @Email(message = "Must be a valid email")
        String email,

        @NotBlank
        String mobilePhoneNumber,

        String homePhoneNumber,
        Gender gender,

        @NotNull
        LocalDate birthDate,

        @CPF(message = "Must be a valid CPF")
        String cpf,

        @NotNull
        Boolean agreesOnTermsAndConditions
) {
}
