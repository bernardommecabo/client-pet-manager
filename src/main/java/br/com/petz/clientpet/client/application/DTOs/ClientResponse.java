package br.com.petz.clientpet.client.application.DTOs;

import br.com.petz.clientpet.client.domain.ClientEntity;

import java.util.UUID;

public record ClientResponse(
        UUID clientId
) {
    public ClientResponse(ClientEntity client){
        this(client.getClientId());
    }
}
