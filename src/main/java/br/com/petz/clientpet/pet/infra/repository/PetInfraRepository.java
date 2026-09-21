package br.com.petz.clientpet.pet.infra.repository;

import br.com.petz.clientpet.handlers.exceptions.APIException;
import br.com.petz.clientpet.pet.domain.PetEntity;
import br.com.petz.clientpet.pet.domain.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

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
}
