package br.com.petz.clientpet.pet.application.api;

import br.com.petz.clientpet.pet.application.DTOs.requests.PetUpdateRequest;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetInfoResponse;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetListResponse;
import br.com.petz.clientpet.pet.application.DTOs.requests.PetRequest;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetResponse;
import br.com.petz.clientpet.pet.application.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PetController implements PetAPI {
    private final PetService petService;

    @Override
    public PetResponse postPet(UUID clientId, PetRequest request) {
        log.info("[start] PetController - postPet");
        PetResponse response = petService.createPet(clientId,request);
        log.info("[finish] PetController - postPet");
        return response;
    }

    @Override
    public PetInfoResponse getPetInfo(UUID clientId, UUID petId) {
        log.info("[start] PetController - getPetInfo");
        PetInfoResponse response = petService.findPetInfo(clientId,petId);
        log.info("[finish] PetController - getPetInfo");
        return response;
    }

    @Override
    public List<PetListResponse> getPetsListFromClientId(UUID clientId) {
        log.info("[start] PetController - getPetsListFromClientId");
        List<PetListResponse> responses = petService.findAllPetsFromClient(clientId);
        log.info("[finish] PetController - getPetsListFromClientId");
        return responses;
    }

    @Override
    public void patchPet(UUID clientId, UUID petId, PetUpdateRequest request) {
        log.info("[start] PetController - patchPet");
        petService.updatePet(clientId,petId,request);
        log.info("[finish] PetController - patchPet");
    }

    @Override
    public void deletePet(UUID clientId, UUID petId) {
        log.info("[start] PetController - deletePet");
        petService.deletePet(clientId,petId);
        log.info("[finish] PetController - deletePet");
    }
}
