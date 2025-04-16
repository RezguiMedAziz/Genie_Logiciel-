package com.C_TechProject.Tier;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PersonnePhysiqueRepository extends JpaRepository<PersonPhysique, Integer> {
     // Ensure "cin" matches the field name in PersonPhysique
     Optional<PersonPhysique> findByCin(String cin);
}

