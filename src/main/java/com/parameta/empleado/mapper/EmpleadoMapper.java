package com.parameta.empleado.mapper;

import com.parameta.empleado.dto.EmpleadoDto;
import com.parameta.empleado.model.Empleado;
import com.parameta.empleado.model.Response;
import com.parameta.empleado.model.domain.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class EmpleadoMapper {

    public static Empleado mapDomainToModel(Employee empleado){
        Empleado employeeModel = Empleado.builder()
                .id(empleado.getId())
                .names(empleado.getNames())
                .lastNames(empleado.getLastNames())
                .documentType(empleado.getDocumentType())
                .documentNumber(empleado.getDocumentNumber())
                .birthDate(empleado.getBirthDate())
                .startDate(empleado.getStartDate())
                .post(empleado.getPost())
                .salary(empleado.getSalary()).build();
        return employeeModel;
    }

    public static Employee mapModelToDomain(Empleado employeeModel){
        Employee employee = Employee.builder()
                .id(employeeModel.getId())
                .names(employeeModel.getNames())
                .lastNames(employeeModel.getLastNames())
                .documentType(employeeModel.getDocumentType())
                .documentNumber(employeeModel.getDocumentNumber())
                .birthDate(employeeModel.getBirthDate())
                .startDate(employeeModel.getStartDate())
                .post(employeeModel.getPost())
                .salary(employeeModel.getSalary()).build();
        return employee;
    }

    public static Employee mapCreationToDomain(EmpleadoDto employeeCreationDto){
        Employee employee = Employee.builder()
                .names(employeeCreationDto.getNames())
                .lastNames(employeeCreationDto.getLastNames())
                .documentType(employeeCreationDto.getDocumentType())
                .documentNumber(employeeCreationDto.getDocumentNumber())
                .birthDate(employeeCreationDto.getBirthDate())
                .startDate(employeeCreationDto.getStartDate())
                .post(employeeCreationDto.getPost())
                .salary(employeeCreationDto.getSalary()).build();
        return employee;
    }

    public static Response mapDomainToInformation(Employee employee){
        Response employeeDto = Response.builder()
                .names(employee.getNames())
                .lastNames(employee.getLastNames())
                .documentType(employee.getDocumentType())
                .documentNumber(employee.getDocumentNumber())
                .age(convertBirthDate(employee.getBirthDate()))
                .antiquity(convertStartDate(employee.getStartDate()))
                .post(employee.getPost())
                .salary(employee.getSalary()).build();
        return employeeDto;
    }
    private static String convertBirthDate(Date date){
        LocalDate today=  LocalDate.now();
        String result;
        LocalDate birthDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(birthDate,today);
        int years = Math.abs(period.getYears());
        int months = Math.abs(period.getMonths());
        int days = Math.abs(period.getDays());
        result = "years: "+ years + "- months: " + months + "- days: " + days;
        return result;
    }

    private static String convertStartDate(Date date){
        LocalDate today=  LocalDate.now();
        String result;
        LocalDate startDay = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(startDay,today);
        int years = Math.abs(period.getYears());
        int months = Math.abs(period.getMonths());
        result = "years: "+ years + "- months: " + months;
        return result;
    }
}
