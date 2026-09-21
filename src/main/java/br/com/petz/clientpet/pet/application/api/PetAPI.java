package br.com.petz.clientpet.pet.application.api;

import br.com.petz.clientpet.pet.application.DTOs.requests.PetRequest;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/client/{clientId}/pet")
public interface PetAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PetResponse postPet(@PathVariable UUID clientId, @Valid @RequestBody PetRequest request);
}
