package com.emp.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.app.model.Employee;
import com.emp.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository emprepo;

	@Override
	public Employee saveEmployee(Employee emp) {

		Employee saveEmployee = emprepo.save(emp);

		return saveEmployee;
	}

	@Override
	public List<Employee> savaeAllEmployee(List<Employee> emps) {

		List<Employee> saveAll = emprepo.saveAll(emps);

		return saveAll;
	}

	@Override
	public Employee getEmployee(int id) {

		Optional<Employee> getemp = emprepo.findById(id);

		   
		  return getemp.orElse(null);
	}

	@Override
	public List<Employee> getAllEmployees() {
	
		List<Employee> findAll = emprepo.findAll();
		
		
		
		return findAll;
	}

	@Override
	public Employee empUpdate(int id, Employee emp) {

                Optional<Employee> existEmpId = emprepo.findById(id);
                if(existEmpId.isPresent())
                {
                	Employee exitsemployee = existEmpId.get();
                	
                	exitsemployee.setFname(emp.getFname());
                	exitsemployee.setLname(emp.getLname());
                	exitsemployee.setAge(emp.getAge());
                	exitsemployee.setCity(emp.getCity());
                	exitsemployee.setMobNo(emp.getMobNo());
                	
                return  emprepo.save(exitsemployee);
                }
		
		return null;
	}

	@Override
	public void deleteEmp(int id) {
		
		
		emprepo.deleteById(id);
	}
	
	

}
