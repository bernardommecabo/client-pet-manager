package br.com.petz.clientpet.client.application.mapper;

import br.com.petz.clientpet.client.application.DTOs.ClientListResponse;
import br.com.petz.clientpet.client.application.DTOs.ClientRequest;
import br.com.petz.clientpet.client.application.DTOs.ClientResponse;
import br.com.petz.clientpet.client.domain.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientEntity toEntity(ClientRequest clientRequest);
    ClientListResponse toListResponse(ClientEntity clientEntity);
    ClientResponse toResponse(ClientEntity clientEntity);
}
