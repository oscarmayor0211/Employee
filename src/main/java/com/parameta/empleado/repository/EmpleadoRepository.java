package com.parameta.empleado.repository;

import com.parameta.empleado.model.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
}
