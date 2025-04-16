package com.C_TechProject.Tier;

import jakarta.persistence.*;
import lombok.Data;


@Data
@MappedSuperclass

public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "contact")
    private String contact;

    @Column(name = "rib")
    private String rib;
}