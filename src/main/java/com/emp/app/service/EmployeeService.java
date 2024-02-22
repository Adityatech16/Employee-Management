package com.emp.app.service;

import java.util.List;

import com.emp.app.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee emp);
	
	public List<Employee> savaeAllEmployee(List<Employee> emps);
	
	 public  Employee  getEmployee(int id );
	
 	public List<Employee> getAllEmployees();
//	
//	public  String  getEmp(int id );
//	
//	public List<Employee> getAllEmp(int id);
//	
	public Employee empUpdate(int id,Employee emp);
//	
    public void deleteEmp(int id);
//	
//	


	
	
	
	
	
}
