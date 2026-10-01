package br.com.petz.clientpet.pet.domain.repository;

import br.com.petz.clientpet.pet.domain.PetEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PetRepository {
    PetEntity savePet(PetEntity pet);
    Page<PetEntity> findAll(UUID clientId, Pageable pageable);
    PetEntity findPet(UUID petId);
    void deletePet(UUID petId);

}
