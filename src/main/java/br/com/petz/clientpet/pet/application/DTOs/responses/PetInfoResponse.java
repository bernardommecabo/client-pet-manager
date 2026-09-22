package br.com.petz.clientpet.pet.application.DTOs.responses;

import br.com.petz.clientpet.pet.domain.PetGender;
import br.com.petz.clientpet.pet.domain.PetType;
import br.com.petz.clientpet.pet.domain.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record PetInfoResponse(
        UUID petId,
        UUID clientId,
        String petName,
        Size size,
        PetType petType,
        String microchipNumber,
        String breed,
        PetGender gender,
        String furColor,
        LocalDate birthDate,
        String RGA,
        BigDecimal weight,
        LocalDateTime createdAt
) {
}
