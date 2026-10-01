package br.com.petz.clientpet.pet.application.service;

import br.com.petz.clientpet.client.domain.ClientEntity;
import br.com.petz.clientpet.client.domain.repository.ClientRepository;
import br.com.petz.clientpet.handlers.exceptions.APIException;
import br.com.petz.clientpet.pet.application.DTOs.requests.PetUpdateRequest;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetInfoResponse;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetListResponse;
import br.com.petz.clientpet.pet.application.DTOs.responses.PetResponse;
import br.com.petz.clientpet.pet.application.DTOs.requests.PetRequest;
import br.com.petz.clientpet.pet.application.mapper.PetMapper;
import br.com.petz.clientpet.pet.domain.PetEntity;
import br.com.petz.clientpet.pet.domain.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class PetApplicationService implements PetService {
    private final PetMapper petMapper;
    private final PetRepository petRepository;
    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public PetResponse createPet(UUID clientId, PetRequest request) {
        log.info("[start] PetApplicationService - createPet");
        ClientEntity client = clientRepository.findClient(clientId);

        PetEntity pet = petMapper.toEntity(request,client);
        PetEntity savedPet = petRepository.savePet(pet);

        log.info("[finish] PetApplicationService - createPet");
        return petMapper.toResponse(savedPet);
    }

    @Override
    @Transactional
    public List<PetListResponse> findAllPetsFromClient(UUID clientId) {
        log.info("[start] PetApplicationService - findAllPetsFromClient");
        clientRepository.findClient(clientId);
        List<PetEntity> pets = petRepository.findAll(clientId);
        log.info("[finish] PetApplicationService - findAllPetsFromClient");
        return pets.stream()
                .map(petMapper::toListResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PetInfoResponse findPetInfo(UUID clientId, UUID petId) {
        log.info("[start] PetApplicationService - findPetInfo");
        PetEntity pet = findPetOrThrow(clientId,petId);
        log.info("[finish] PetApplicationService - findPetInfo");
        return petMapper.toInfoResponse(pet);
    }

    @Override
    @Transactional
    public void deletePet(UUID clientId, UUID petId) {
        log.info("[start] PetApplicationService - deletePet");
        PetEntity pet = findPetOrThrow(clientId,petId);
        petRepository.deletePet(pet.getPetId());
        log.info("[finish] PetApplicationService - deletePet");
    }

    @Override
    @Transactional
    public void updatePet(UUID clientId, UUID petId, PetUpdateRequest request) {
        log.info("[start] PetApplicationService - updatePet");
        PetEntity pet = findPetOrThrow(clientId,petId);
        petMapper.updateEntityFromRequest(request,pet);
        petRepository.savePet(pet);
        log.info("[finish] PetApplicationService - updatePet");
    }

    private void validateOwnership(UUID clientId, PetEntity pet) {
        if(!pet.getClient().getClientId().equals(clientId)){
            throw APIException.build(HttpStatus.NOT_FOUND,"Pet not found for this client");
        }
    }
    private PetEntity findPetOrThrow(UUID clientId, UUID petId) {
        clientRepository.findClient(clientId);
        PetEntity pet = petRepository.findPet(petId);
        validateOwnership(clientId,pet);
        return pet;
    }
}
