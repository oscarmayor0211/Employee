package com.parameta.empleado.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class EmpleadoDto {
    @NotNull
    @NotBlank
    private String names;
    @NotNull
    @NotBlank
    private String lastNames;
    @NotNull
    @NotBlank
    private String documentType;
    @NotNull
    @NotBlank
    private String documentNumber;
    @NotNull
    @Past
    private Date birthDate;
    @NotNull
    @Past
    private Date startDate;
    @NotNull
    @NotBlank
    private String post;
    @NotNull
    @Min(1)
    private Double salary;
}
