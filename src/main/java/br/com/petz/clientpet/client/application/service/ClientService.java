package br.com.petz.clientpet.client.application.service;

import br.com.petz.clientpet.client.application.DTOs.ClientRequest;
import br.com.petz.clientpet.client.application.DTOs.ClientResponse;

public interface ClientService {
    ClientResponse createClient(ClientRequest request);
}
