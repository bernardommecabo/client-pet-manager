package br.com.petz.clientpet.pet.application.api;

import br.com.petz.clientpet.pet.application.DTOs.requests.PetUpdateRequest;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetInfoResponse;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetListResponse;
import br.com.petz.clientpet.pet.application.DTOs.requests.PetRequest;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetResponse;
import br.com.petz.clientpet.utils.DTOs.PageResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/client/{clientId}/pet")
public interface PetAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PetResponse postPet(@PathVariable UUID clientId, @Valid @RequestBody PetRequest request);

    @GetMapping("/{petId}")
    @ResponseStatus(HttpStatus.OK)
    PetInfoResponse getPetInfo(@PathVariable UUID clientId, @PathVariable UUID petId);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    PageResponse<PetListResponse> getPetsListFromClientId(@PathVariable UUID clientId,
                                                          @PageableDefault(size = 5, sort = "petName") Pageable pageable);

    @PatchMapping("/{petId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void patchPet(@PathVariable UUID clientId, @PathVariable UUID petId,@Valid @RequestBody PetUpdateRequest request);

    @DeleteMapping("/{petId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePet(@PathVariable UUID clientId, @PathVariable UUID petId);
}
