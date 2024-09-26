package com.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Employees;
import com.app.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	// Save Employee with both static and dynamic fields
	public Employees addEmployee(String firstName, String lastName, String email, String department, Integer salary,
			List<Map<String,Object>> dynamicFields) {
		Employees employee = new Employees();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setDepartment(department);
		employee.setSalary(salary);
		employee.setDynamicFields(dynamicFields);

		return employeeRepository.save(employee);
	}

	// Fetch employee by ID
	public Employees getEmployeeById(Integer employeeId) {
		return employeeRepository.findById(employeeId).orElse(null);
	}

	// Update an employee
	public Employees updateEmployee(Integer employeeId, String firstName, String lastName, String email,
			String department, Integer salary, List<Map<String, Object>> dynamicFields) {
		Employees existingEmployee = getEmployeeById(employeeId);
		if (existingEmployee != null) {
			existingEmployee.setFirstName(firstName);
			existingEmployee.setLastName(lastName);
			existingEmployee.setEmail(email);
			existingEmployee.setDepartment(department);
			existingEmployee.setSalary(salary);
			existingEmployee.setDynamicFields(dynamicFields);

			return employeeRepository.save(existingEmployee);
		}
		return null;
	}

	public List<Employees> getAllEmployees() {
		return employeeRepository.findAll();
	}

//	public Employees getEmployeeById(Long id) {
//		return employeeRepository.findById(id).orElse(null);
//	}

	public Employees saveEmployee(Employees employee) {
		return employeeRepository.save(employee);
	}
//
//	public void deleteEmployee(Long id) {
//		employeeRepository.deleteById(id);
//	}
}