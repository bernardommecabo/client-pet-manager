package br.com.petz.clientpet.pet.infra.repository;

import br.com.petz.clientpet.handlers.exceptions.APIException;
import br.com.petz.clientpet.pet.domain.PetEntity;
import br.com.petz.clientpet.pet.domain.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class PetInfraRepository implements PetRepository {
    private final PetSpringDataJpaRepository repository;

    @Override
    public PetEntity savePet(PetEntity pet) {
        log.info("[start] PetRepository - savePet");
        try {
            repository.save(pet);
        }catch (DataIntegrityViolationException exception){
            throw APIException.build(HttpStatus.CONFLICT, "Pet already exists");
        }
        log.info("[finish] PetRepository - savePet");
        return pet;
    }

    @Override
    public List<PetEntity> findAll(UUID clientId) {
        log.info("[start] PetRepository - findAll");
        List<PetEntity> pets = repository.findAllByClientId(clientId);
        log.info("[finish] PetRepository - findAll");
        return pets;
    }

    @Override
    public PetEntity findPet(UUID petId) {
        log.info("[start] PetRepository - findPet");
        PetEntity pet = repository.findById(petId)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pet not found"));
        log.info("[finish] PetRepository - findPet");
        return pet;
    }

    @Override
    public void deletePet(UUID petId) {
        log.info("[start] PetRepository - deletePet");
        repository.deleteById(petId);
        log.info("[finish] PetRepository - deletePet");
    }
}
