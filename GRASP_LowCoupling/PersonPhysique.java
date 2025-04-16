package com.C_TechProject.Tier;

import com.C_TechProject.Operation.Operation;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Entity
@Table(name = "_person_physique")
@Data
public class PersonPhysique extends Person {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "cin")
    private String cin;

    @Column(name = "adresse")
    private String adresse;

    @OneToMany(mappedBy = "personnePhysique", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Operation> operations;

    // Corrected constructor - removed unused requestAdresse parameter
    public PersonPhysique(String email, String contact, String rib,
                          String firstName, String lastName,
                          String cin, String adresse, List<Operation> operations) {
        setEmail(email);
        setContact(contact);
        setRib(rib);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cin = cin;
        this.adresse = adresse;
        this.operations = operations;
    }

    // Add no-args constructor for JPA
    public PersonPhysique() {}
}