package com.C_TechProject.Tier;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


import java.util.Optional;


public interface PersonneMoraleRepository extends JpaRepository<PersonMorale, Integer> {
     // Ensure "code" matches the field name in PersonMorale
     Optional<PersonMorale> findByCode(String code);
}