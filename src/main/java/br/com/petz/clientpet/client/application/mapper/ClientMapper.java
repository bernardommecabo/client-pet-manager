package br.com.petz.clientpet.client.application.mapper;

import br.com.petz.clientpet.client.application.DTOs.responses.ClientInfoResponse;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientListResponse;
import br.com.petz.clientpet.client.application.DTOs.requests.ClientRequest;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientResponse;
import br.com.petz.clientpet.client.domain.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientEntity toEntity(ClientRequest clientRequest);

    ClientResponse toResponse(ClientEntity clientEntity);
    ClientListResponse toListResponse(ClientEntity clientEntity);
    ClientInfoResponse toInfoResponse(ClientEntity clientEntity);
}
