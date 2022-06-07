package com.parameta.empleado.controller;

import com.parameta.empleado.Service.serviceEmpleado;
import com.parameta.empleado.dto.EmpleadoDto;
import com.parameta.empleado.mapper.EmpleadoMapper;
import com.parameta.empleado.model.Response;
import com.parameta.empleado.model.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("empleado")
public class EmpleadoController {

    @Autowired
    serviceEmpleado serviceEmpleado;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Response createEmployee(@Valid @RequestBody EmpleadoDto empleado){
        Employee employee = EmpleadoMapper.mapCreationToDomain(empleado);
        Response employeeInformation = EmpleadoMapper.mapDomainToInformation(employee);
        serviceEmpleado.createEmpleado(employee);
        return  employeeInformation;
    }
}
