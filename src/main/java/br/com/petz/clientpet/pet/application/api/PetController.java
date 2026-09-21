package br.com.petz.clientpet.pet.application.api;

import br.com.petz.clientpet.pet.application.DTOs.requests.PetRequest;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetResponse;
import br.com.petz.clientpet.pet.application.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PetController implements PetAPI {
    private final PetService petService;

    @Override
    public PetResponse postPet(UUID clientId, PetRequest request) {
        log.info("[start] ClientController - postPet");
        PetResponse response = petService.createPet(request);
        log.info("[finish] ClientController - postPet");
        return response;
    }
}
