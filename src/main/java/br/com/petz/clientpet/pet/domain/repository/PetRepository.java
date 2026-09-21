package br.com.petz.clientpet.pet.domain.repository;

import br.com.petz.clientpet.pet.domain.PetEntity;

import java.util.List;
import java.util.UUID;

public interface PetRepository {
    PetEntity savePet(PetEntity pet);
    List<PetEntity> findAll(UUID clientId);
}
