package com.C_TechProject.Tier;

import com.C_TechProject.Operation.OperationRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonMoraleService extends BasePersonService<PersonMorale> {

    private final PersonneMoraleRepository repository;

    public PersonMoraleService(PersonneMoraleRepository repository, OperationRepository operationRepository) {
        super(repository, operationRepository);
        this.repository = repository;
    }

    @Override
    protected void validateUniqueFields(PersonMorale entity) {
        repository.findByCode(entity.getCode()).ifPresent(person -> {
            throw new IllegalArgumentException("Code déjà utilisé");
        });
    }

    @Override
    protected void updateSpecificFields(PersonMorale existing, PersonMorale newEntity) {
        if (newEntity.getName() != null) existing.setName(newEntity.getName());
        if (newEntity.getCode() != null) existing.setCode(newEntity.getCode());
    }

    @Override
    protected void checkAssociatedOperations(PersonMorale entity) {
        if (!operationRepository.findByPersonneMorale(entity).isEmpty()) {
            throw new RuntimeException("Opérations associées existantes");
        }
    }
}
