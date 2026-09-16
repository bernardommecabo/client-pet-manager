package br.com.petz.clientpet.client.application.api;

import br.com.petz.clientpet.client.application.DTOs.responses.ClientInfoResponse;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientListResponse;
import br.com.petz.clientpet.client.application.DTOs.requests.ClientRequest;
import br.com.petz.clientpet.client.application.DTOs.responses.ClientResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Validated
@RequestMapping("/v1/client")
public interface ClientAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ClientResponse postClient(@RequestBody @Valid ClientRequest request);

    @GetMapping("/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    ClientInfoResponse getClient(@PathVariable UUID clientId);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ClientListResponse> getAllClients();

}
