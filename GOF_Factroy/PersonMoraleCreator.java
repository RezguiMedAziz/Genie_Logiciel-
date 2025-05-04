package com.C_TechProject.Tier;

import org.springframework.stereotype.Component;

@Component
public class PersonMoraleCreator implements PersonCreator {

    @Override
    public String getType() {
        return "morale";
    }

    @Override
    public Person create(PersonRequest request) {
        return new PersonMorale(
                request.getEmail(),
                request.getContact(),
                request.getRib(),
                request.getName(),
                request.getCode(),
                null
        );
    }
}
