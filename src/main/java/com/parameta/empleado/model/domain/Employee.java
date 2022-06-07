package com.parameta.empleado.model.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Employee {
    private Long id;
    private String names;
    private String lastNames;
    private String documentType;
    private String documentNumber;
    private Date birthDate;
    private Date startDate;
    private String post;
    private Double salary;
}