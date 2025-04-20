package com.C_TechProject.Operation;

import com.C_TechProject.Bordereau.Bordereau;
import com.C_TechProject.Tier.PersonMorale;
import com.C_TechProject.Tier.PersonPhysique;
import com.C_TechProject.bank.Bank;
import com.C_TechProject.bankAccount.BankAccount;
import com.C_TechProject.legalEntity.LegalEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "_Operation")
@Getter
@Setter
@ToString(exclude = {"bordereau", "personnePhysique", "personneMorale"}) // Prevent circular references
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;
    private String etat;

    @Column(nullable = true)
    private String numcheque;

    private String reglement;
    private String montant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "legal_entity_id")
    private LegalEntity legalEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personnePhysique_id")
    private PersonPhysique personnePhysique;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personneMorale_id")
    private PersonMorale personneMorale;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bordereau_id")
    private Bordereau bordereau;

    public Operation() {
        // creationDate is now handled by @CreationTimestamp
    }

    // Business logic methods
    public boolean isChequeOperation() {
        return numcheque != null && !numcheque.isEmpty();
    }

    @PrePersist
    protected void validate() {
        if (montant == null || montant.isEmpty()) {
            throw new IllegalStateException("Operation amount cannot be empty");
        }
    }
}
