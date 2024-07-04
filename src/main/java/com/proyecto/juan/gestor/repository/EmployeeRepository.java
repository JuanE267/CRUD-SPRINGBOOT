package com.proyecto.juan.gestor.repository;


import com.proyecto.juan.gestor.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
