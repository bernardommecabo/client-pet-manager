package br.com.petz.clientpet.pet.application.service;

import br.com.petz.clientpet.client.domain.repository.ClientRepository;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetResponse;
import br.com.petz.clientpet.pet.application.DTOs.requests.PetRequest;
import br.com.petz.clientpet.pet.application.mapper.PetMapper;
import br.com.petz.clientpet.pet.domain.PetEntity;
import br.com.petz.clientpet.pet.domain.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class PetApplicationService implements PetService {
    private final PetMapper petMapper;
    private final PetRepository petRepository;
    private final ClientRepository clientRepository;

    @Override
    public PetResponse createPet(UUID clientId, PetRequest request) {
        log.info("[start] PetApplicationService - createPet");
        clientRepository.findClient(clientId);
        PetEntity pet = petMapper.toEntity(request,clientId);
        PetEntity savedPet = petRepository.savePet(pet);
        log.info("[finish] PetApplicationService - createPet");
        return petMapper.toResponse(savedPet);
    }
}
