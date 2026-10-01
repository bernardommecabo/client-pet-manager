package br.com.petz.clientpet.pet.application.service;

import br.com.petz.clientpet.pet.application.DTOs.requests.PetUpdateRequest;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetInfoResponse;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetListResponse;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetResponse;
import br.com.petz.clientpet.pet.application.DTOs.requests.PetRequest;
import br.com.petz.clientpet.utils.DTOs.PageResponse;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PetService {
    PetResponse createPet(UUID clientId, PetRequest request);
    PageResponse<PetListResponse> findAllPetsFromClient(UUID clientId, Pageable pageable);
    PetInfoResponse findPetInfo(UUID clientId, UUID petId);
    void deletePet(UUID clientId, UUID petId);
    void updatePet(UUID clientId, UUID petId, PetUpdateRequest request);
}
