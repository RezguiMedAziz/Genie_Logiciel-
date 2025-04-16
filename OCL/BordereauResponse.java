package com.C_TechProject.Bordereau;

import com.C_TechProject.Operation.OperationResponse;
import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder

public class BordereauResponse {
    private Integer id;
    private String number;
    private String type;
    private String reglement;
    private LocalDate date;
    private String totalAmount;
    private List<OperationResponse> operations;
    private String operationCount;


}