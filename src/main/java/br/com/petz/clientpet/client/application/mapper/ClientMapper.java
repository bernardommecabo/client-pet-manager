package br.com.petz.clientpet.client.application.mapper;

import br.com.petz.clientpet.client.application.DTOs.requests.ClientUpdateRequest;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientInfoResponse;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientListResponse;
import br.com.petz.clientpet.client.application.DTOs.requests.ClientRequest;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientResponse;
import br.com.petz.clientpet.client.domain.ClientEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientEntity toEntity(ClientRequest clientRequest);

    @Mapping(target = "clientId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lastUpdatedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(ClientUpdateRequest request, @MappingTarget ClientEntity clientEntity);

    ClientResponse toResponse(ClientEntity clientEntity);
    ClientListResponse toListResponse(ClientEntity clientEntity);
    ClientInfoResponse toInfoResponse(ClientEntity clientEntity);
}
