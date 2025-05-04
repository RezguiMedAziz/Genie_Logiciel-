package com.C_TechProject.Tier;

import org.springframework.stereotype.Component;

@Component
public class PersonPhysiqueCreator implements PersonCreator {

    @Override
    public String getType() {
        return "physique";
    }

    @Override
    public Person create(PersonRequest request) {
        return new PersonPhysique(
                request.getEmail(),
                request.getContact(),
                request.getRib(),
                request.getFirstName(),
                request.getLastName(),
                request.getCin(),
                request.getAdresse(),
                null
        );
    }
}
