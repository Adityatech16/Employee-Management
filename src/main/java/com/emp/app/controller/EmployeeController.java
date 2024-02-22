package com.emp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.app.model.Employee;
import com.emp.app.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> savaEmployee(@RequestBody Employee emp) {

		Employee saveEmployee = empservice.saveEmployee(emp);

		return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
	}

	@RequestMapping("/addAllEmp")
	public ResponseEntity<List<Employee>> saveAllEmployee(@RequestBody List<Employee> emps) {
		List<Employee> savaeAllEmployee = empservice.savaeAllEmployee(emps);

		return new ResponseEntity<>(savaeAllEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/getEmp/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {

		Employee employee = empservice.getEmployee(id);

		if (employee != null) {
			return ResponseEntity.ok(employee);
		}

		log.info("employee data " + employee);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@GetMapping("/getEmps")
	public ResponseEntity<List<Employee>> getAllEmployees() {

		List<Employee> allEmployees = empservice.getAllEmployees();

		if (!allEmployees.isEmpty()) {
			return ResponseEntity.ok(allEmployees);
		}

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	@PutMapping("empupdate/{id}")
	public ResponseEntity<Employee> updateEmp(@PathVariable int id, @RequestBody Employee emp) {
		Employee empUpdate = empservice.empUpdate(id, emp);

		if (empUpdate != null) {
			return ResponseEntity.ok(empUpdate);
		}

		else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("deleteemp/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable int id) {
	    empservice.deleteEmp(id);
	    return ResponseEntity.ok("Employee with ID " + id + " deleted successfully.");
	}
}
