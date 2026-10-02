package br.com.petz.clientpet.auth.user.application.mapper;

import br.com.petz.clientpet.auth.user.application.DTOs.request.UserRegisterRequest;
import br.com.petz.clientpet.auth.user.application.DTOs.response.UserRegisterResponse;
import br.com.petz.clientpet.auth.user.domain.UserEntity;
import br.com.petz.clientpet.client.domain.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "client", source = "client")
    @Mapping(target = "email", source = "request.email")
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lastUpdatedAt", ignore = true)
    UserEntity toEntity(UserRegisterRequest request, ClientEntity client);

    @Mapping(target = "clientId", source = "client.clientId")
    UserRegisterResponse toResponse(UserEntity user);
}
