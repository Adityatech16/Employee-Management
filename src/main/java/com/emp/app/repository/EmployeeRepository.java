package com.emp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
