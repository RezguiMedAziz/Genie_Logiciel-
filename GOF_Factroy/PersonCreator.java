package com.C_TechProject.Tier;

public interface PersonCreator {
    String getType(); // e.g., "morale", "physique"
    Person create(PersonRequest request);
}
