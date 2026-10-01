package br.com.petz.clientpet.pet.application.mapper;

import br.com.petz.clientpet.client.domain.ClientEntity;
import br.com.petz.clientpet.pet.application.DTOs.requests.PetUpdateRequest;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetInfoResponse;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetListResponse;
import br.com.petz.clientpet.pet.application.DTOs.requests.PetRequest;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetResponse;
import br.com.petz.clientpet.pet.domain.PetEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PetMapper {
    @Mapping(target = "client", source = "client")
    @Mapping(target = "gender", source = "request.gender")
    @Mapping(target = "birthDate", source = "request.birthDate")
    @Mapping(target = "petId", ignore = true)
    @Mapping(target = "microchipNumber", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lastUpdatedAt", ignore = true)
    PetEntity toEntity(PetRequest request, ClientEntity client);

    @Mapping(target = "petId", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lastUpdatedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(PetUpdateRequest request, @MappingTarget PetEntity petEntity);

    PetResponse toResponse(PetEntity pet);

    @Mapping(target = "clientId", source = "client.clientId")
    PetInfoResponse toInfoResponse(PetEntity pet);

    PetListResponse toListResponse(PetEntity pet);
}
