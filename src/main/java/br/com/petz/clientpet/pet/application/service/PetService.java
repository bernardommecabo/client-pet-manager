package br.com.petz.clientpet.pet.application.service;

import br.com.petz.clientpet.pet.application.DTOs.responses.PetResponse;
import br.com.petz.clientpet.pet.application.DTOs.requests.PetRequest;

public interface PetService {
    PetResponse createPet(PetRequest request);
}
