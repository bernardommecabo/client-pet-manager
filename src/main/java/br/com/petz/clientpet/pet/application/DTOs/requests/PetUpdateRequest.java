package br.com.petz.clientpet.pet.application.DTOs.requests;

import br.com.petz.clientpet.pet.domain.PetGender;
import br.com.petz.clientpet.pet.domain.PetType;
import br.com.petz.clientpet.pet.domain.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PetUpdateRequest(
        @NotBlank(message = "Pet must have a name")
        String petName,

        Size size,

        @NotNull(message = "Must have a pet type")
        PetType petType,

        String microchipNumber,

        @NotBlank(message = "Must have a breed")
        String breed,

        @NotNull(message = "Must have a gender")
        PetGender gender,

        String furColor,

        @NotNull(message = "Must have a birth date")
        LocalDate birthDate,

        String RGA,
        BigDecimal weight
) {
}
