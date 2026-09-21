package br.com.petz.clientpet.pet.application.DTOs;

import br.com.petz.clientpet.pet.domain.PetType;

import java.time.LocalDate;
import java.util.UUID;

public record PetListResponse(
        UUID petId,
        String petName,
        PetType petType,
        String breed,
        String furColor,
        LocalDate birthDate
) {
}
