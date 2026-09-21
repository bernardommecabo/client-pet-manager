package br.com.petz.clientpet.pet.application.mapper;

import br.com.petz.clientpet.pet.application.DTOs.requests.PetRequest;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetResponse;
import br.com.petz.clientpet.pet.domain.PetEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {
    PetEntity toEntity(PetRequest request);

    PetResponse toResponse(PetEntity pet);
}
