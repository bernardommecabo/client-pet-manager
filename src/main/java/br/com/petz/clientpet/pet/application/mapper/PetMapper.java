package br.com.petz.clientpet.pet.application.mapper;

import br.com.petz.clientpet.pet.application.DTOs.requests.PetUpdateRequest;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetInfoResponse;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetListResponse;
import br.com.petz.clientpet.pet.application.DTOs.requests.PetRequest;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetResponse;
import br.com.petz.clientpet.pet.domain.PetEntity;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface PetMapper {
    @Mapping(target = "clientId", source = "clientId")
    PetEntity toEntity(PetRequest request, UUID clientId);

    @Mapping(target = "petId", ignore = true)
    @Mapping(target = "clientId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lastUpdatedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(PetUpdateRequest request, @MappingTarget PetEntity petEntity);

    PetResponse toResponse(PetEntity pet);
    PetInfoResponse toInfoResponse(PetEntity pet);
    PetListResponse toListResponse(PetEntity pet);
}
