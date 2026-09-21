package br.com.petz.clientpet.pet.application.service;

import br.com.petz.clientpet.pet.application.DTOs.responses.PetResponse;
import br.com.petz.clientpet.pet.application.DTOs.requests.PetRequest;
import br.com.petz.clientpet.pet.application.mapper.PetMapper;
import br.com.petz.clientpet.pet.domain.PetEntity;
import br.com.petz.clientpet.pet.domain.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PetApplicationService implements PetService {
    private final PetMapper petMapper;
    private final PetRepository petRepository;

    @Override
    public PetResponse createPet(PetRequest request) {
        log.info("[start] ClientService - createPet");
        PetEntity pet = petRepository.savePet(petMapper.toEntity(request));
        log.info("[finish] ClientService - createPet");
        return petMapper.toResponse(pet);
    }
}
