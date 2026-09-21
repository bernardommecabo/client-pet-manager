package br.com.petz.clientpet.pet.application.service;

import br.com.petz.clientpet.pet.application.DTOs.responses.PetResponse;
import br.com.petz.clientpet.pet.application.DTOs.requests.PetRequest;

import java.util.UUID;

public interface PetService {
    PetResponse createPet(UUID clientId, PetRequest request);
}
