package com.C_TechProject.Operation;

import com.C_TechProject.Bordereau.Bordereau;
import com.C_TechProject.Bordereau.BordereauOperationService;
import com.C_TechProject.Bordereau.BordereauRepository;
import com.C_TechProject.Tier.PersonMorale;
import com.C_TechProject.Tier.PersonPhysique;
import com.C_TechProject.Tier.PersonneMoraleRepository;
import com.C_TechProject.Tier.PersonnePhysiqueRepository;
import com.C_TechProject.bank.Bank;
import com.C_TechProject.bank.BankRepository;
import com.C_TechProject.bankAccount.BankAccount;
import com.C_TechProject.bankAccount.BankAccountRepository;
import com.C_TechProject.legalEntity.LegalEntity;
import com.C_TechProject.legalEntity.LegalEntityRepository;
import com.C_TechProject.user.UserNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Transactional
public class OperationService implements BordereauOperationService {
    private final OperationRepository operationRepository;
    private final BankRepository bankRepository;
    private final BankAccountRepository bankAccountRepository;
    private final LegalEntityRepository legalEntityRepository;
    private final PersonnePhysiqueRepository personnePhysiqueRepository;
    private final PersonneMoraleRepository personneMoraleRepository;
    private final BordereauRepository bordereauRepository;

    public OperationService(OperationRepository operationRepository,
                            BankRepository bankRepository,
                            BankAccountRepository bankAccountRepository,
                            LegalEntityRepository legalEntityRepository,
                            PersonnePhysiqueRepository personnePhysiqueRepository,
                            PersonneMoraleRepository personneMoraleRepository,
                            BordereauRepository bordereauRepository) {
        this.operationRepository = operationRepository;
        this.bankRepository = bankRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.legalEntityRepository = legalEntityRepository;
        this.personnePhysiqueRepository = personnePhysiqueRepository;
        this.personneMoraleRepository = personneMoraleRepository;
        this.bordereauRepository = bordereauRepository;
    }

    // Your existing methods...

    @Override
    public Bordereau addOperations(Integer bordereauId, List<Integer> operationIds) {
        // Find the bordereau by ID
        Bordereau bordereau = bordereauRepository.findById(bordereauId)
                .orElseThrow(() -> new IllegalArgumentException("Bordereau not found with ID: " + bordereauId));

        // Find operations by their IDs and add them to the bordereau
        List<Operation> operations = operationRepository.findAllById(operationIds);
        bordereau.getOperations().addAll(operations);

        // Update the bordereau's operation count
        bordereau.setOperationCount(bordereau.getOperations().size());

        // Save the updated bordereau
        return bordereauRepository.save(bordereau);
    }

    @Override
    public List<OperationResponse> getBordereauOperations(Integer bordereauId) {
        // Find the bordereau by ID
        Bordereau bordereau = bordereauRepository.findById(bordereauId)
                .orElseThrow(() -> new IllegalArgumentException("Bordereau not found with ID: " + bordereauId));

        // Map operations to OperationResponse
        return bordereau.getOperations().stream()
                .map(operation -> {
                    OperationResponse response = new OperationResponse();
                    response.setId(operation.getId());
                    response.setType(operation.getType());
                    response.setEtat(operation.getEtat());
                    response.setMontant(operation.getMontant());
                    response.setReglement(operation.getReglement());
                    response.setNumcheque(operation.getNumcheque());
                    response.setBank(operation.getBank().getNameBanque());
                    response.setLegalEntity(operation.getLegalEntity().getNameEntity());
                    response.setBankAccount(operation.getBankAccount().getRib());
                    response.setPersonnePhysique(operation.getPersonnePhysique() != null ?
                            operation.getPersonnePhysique().getCin() : null);
                    response.setPersonneMorale(operation.getPersonneMorale() != null ?
                            operation.getPersonneMorale().getCode() : null);
                    response.setCreationDate(String.valueOf(operation.getCreationDate()));
                    return response;
                })
                .collect(Collectors.toList());
    }

    // You can also add any additional methods to update or delete operations for a Bordereau,
    // if needed for your application.
}
