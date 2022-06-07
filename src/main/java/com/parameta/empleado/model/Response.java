package com.parameta.empleado.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Response {
    private String names;
    private String lastNames;
    private String documentType;
    private String documentNumber;
    private String antiquity;
    private String age;
    private String post;
    private Double salary;
}
