package com.C_TechProject.Tier;

import com.C_TechProject.Operation.Operation;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "_person_morale")  // Ensure table name matches DB
@Data
@EqualsAndHashCode(callSuper = true)
public class PersonMorale extends Person {
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "personneMorale", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Operation> operations;

    // Corrected constructor - removed unused requestCode parameter
    public PersonMorale(String email, String contact, String rib,
                        String name, String code, List<Operation> operations) {
        setEmail(email);
        setContact(contact);
        setRib(rib);
        this.name = name;
        this.code = code;
        this.operations = operations;
    }

    // Add no-args constructor for JPA
    public PersonMorale() {}
}


