package com.parameta.empleado.Service;

import com.parameta.empleado.exception.EmpleadoException;
import com.parameta.empleado.mapper.EmpleadoMapper;
import com.parameta.empleado.model.Empleado;
import com.parameta.empleado.model.domain.Employee;
import com.parameta.empleado.repository.EmpleadoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
@Service
public class serviceEmpleadoImpl implements serviceEmpleado{

    private final EmpleadoRepository empleadoRepository;
    public serviceEmpleadoImpl(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public Employee createEmpleado(Employee empleado)throws EmpleadoException {
        Integer ageEmployee = this.getAge(empleado.getBirthDate());
        if(ageEmployee >=18){
            Empleado employeeModel = empleadoRepository.save(EmpleadoMapper.mapDomainToModel(empleado));

            return EmpleadoMapper.mapModelToDomain(employeeModel);
        }else {
            throw new EmpleadoException("Empleado menor de edad", "not.found", HttpStatus.NOT_FOUND);
        }
    }

    private Integer getAge(Date date){
        LocalDate today=  LocalDate.now();
        LocalDate birthDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(birthDate,today);
        return Math.abs(period.getYears());
    }
}
