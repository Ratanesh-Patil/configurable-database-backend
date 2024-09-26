package com.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employees;
import com.app.repository.EmployeeRepository;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// POST request to add an employee
	@PostMapping("/add")
	public Employees addEmployee(@RequestBody Map<String, Object> requestBody) {
	    String firstName = (String) requestBody.get("firstName");
	    String lastName = (String) requestBody.get("lastName");
	    String email = (String) requestBody.get("email");
	    String department = (String) requestBody.get("department");
	    Integer salary = (Integer) requestBody.get("salary");
	    
	    // Updated to capture dynamicFields including their metadata (type, key, value)
	    List<Map<String, Object>> dynamicFields = (List<Map<String, Object>>) requestBody.get("dynamicFields");

	    return employeeService.addEmployee(firstName, lastName, email, department, salary, dynamicFields);
	}

	// GET request to fetch an employee by ID
	@GetMapping("/{id}")
	public Employees getEmployee(@PathVariable("id") Integer employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}

	// PUT request to update an employee
	@PutMapping("/update/{id}")
	public Employees updateEmployee(@PathVariable("id") Integer employeeId,
	        @RequestBody Map<String, Object> requestBody) {
	    String firstName = (String) requestBody.get("firstName");
	    String lastName = (String) requestBody.get("lastName");
	    String email = (String) requestBody.get("email");
	    String department = (String) requestBody.get("department");
	    
	    // Safely handle conversion from String to Integer for salary
	    Integer salary = null;
	    Object salaryObj = requestBody.get("salary");
	    if (salaryObj instanceof Number) {
	        salary = ((Number) salaryObj).intValue();
	    } else if (salaryObj instanceof String) {
	        try {
	            salary = Integer.parseInt((String) salaryObj);
	        } catch (NumberFormatException e) {
	            // Handle the exception (e.g., log it or set a default value)
	            System.err.println("Invalid salary format: " + salaryObj);
	            // You might want to throw an exception or return a specific response
	        }
	    }

	    List<Map<String, Object>> dynamicFields = (List<Map<String, Object>>) requestBody.get("dynamicFields");

	    return employeeService.updateEmployee(employeeId, firstName, lastName, email, department, salary,
	            dynamicFields);
	}

	@GetMapping
	public List<Employees> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

//	@GetMapping("/{id}")
//	public Employees getEmployeeById(@PathVariable Long id) {
//		return employeeService.getEmployeeById(id);
//	}

	@PostMapping
	public Employees createEmployee(@RequestBody Employees employee) {
		return employeeService.saveEmployee(employee);
	}

	@PutMapping("/{id}")
	public Employees updateEmployee(@PathVariable Integer id, @RequestBody Employees employee) {
		employee.setEmployeeId(id);
		return employeeService.saveEmployee(employee);
	}

//	@DeleteMapping("/{id}")
//	public void deleteEmployee(@PathVariable Long id) {
//		employeeService.deleteEmployee(id);
//	}
}