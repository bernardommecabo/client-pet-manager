package br.com.petz.clientpet.pet.domain.repository;

import br.com.petz.clientpet.pet.domain.PetEntity;

public interface PetRepository {
    PetEntity savePet(PetEntity pet);
}
