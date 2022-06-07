package com.parameta.empleado.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String names;
    @Column(nullable = false)
    private String lastNames;
    @Column(nullable = false)
    private String documentType;
    @Column(nullable = false)
    private String documentNumber;
    @Column(nullable = false)
    private Date birthDate;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private String post;
    @Column(nullable = false)
    private Double salary;

}