package br.com.petz.clientpet.pet.application.mapper;

import br.com.petz.clientpet.pet.application.DTOs.PetListResponse;
import br.com.petz.clientpet.pet.application.DTOs.requests.PetRequest;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetResponse;
import br.com.petz.clientpet.pet.domain.PetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface PetMapper {
    @Mapping(target = "clientId", source = "clientId")
    PetEntity toEntity(PetRequest request, UUID clientId);

    PetResponse toResponse(PetEntity pet);
    PetListResponse toListResponse(PetEntity pet);
}
