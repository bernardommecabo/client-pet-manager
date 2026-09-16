package br.com.petz.clientpet.client.application.api;

import br.com.petz.clientpet.client.application.DTOs.ClientListResponse;
import br.com.petz.clientpet.client.application.DTOs.ClientRequest;
import br.com.petz.clientpet.client.application.DTOs.ClientResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/v1/client")
public interface ClientAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ClientResponse postClient(@RequestBody @Valid ClientRequest request);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ClientListResponse> getAllClients();

}
