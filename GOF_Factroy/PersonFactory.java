package com.C_TechProject.Tier;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PersonFactory {

    private final Map<String, PersonCreator> creators;

    public PersonFactory(Map<String, PersonCreator> creators) {
        this.creators = creators.entrySet().stream()
                .collect(java.util.stream.Collectors.toMap(
                        entry -> entry.getValue().getType().toLowerCase(),
                        Map.Entry::getValue
                ));
    }

    public Person createPerson(PersonRequest request) {
        PersonCreator creator = creators.get(request.getType().toLowerCase());
        if (creator == null) {
            throw new IllegalArgumentException("Unknown type: " + request.getType());
        }
        return creator.create(request);
    }
}
