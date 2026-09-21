package br.com.petz.clientpet.pet.application.service;

import br.com.petz.clientpet.pet.application.DTOs.PetListResponse;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetResponse;
import br.com.petz.clientpet.pet.application.DTOs.requests.PetRequest;

import java.util.List;
import java.util.UUID;

public interface PetService {
    PetResponse createPet(UUID clientId, PetRequest request);
    List<PetListResponse> findAllPetsFromClient(UUID clientId);
}
