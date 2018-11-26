package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Employee;
import com.yash.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController() {
		System.out.println("EmployeeController called...");
	}

	@PostMapping(value = "/register", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		int returnValue = employeeService.addEmployee(employee);
		if (returnValue != 0)
			return new ResponseEntity<Employee>(HttpStatus.CREATED);
		else
			return new ResponseEntity<Employee>(HttpStatus.NOT_IMPLEMENTED);
	}

	@GetMapping
	@RequestMapping(value = "/listAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employeeList = employeeService.getAllEmployee();
		if (!employeeList.isEmpty()) {
			return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
		} else {
			System.out.println("in else " + employeeList.isEmpty());
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	@RequestMapping(value = "/getEmployeeById/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId);
		if (employee != null)
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		else {
			System.out.println("Inside Else....");
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	@PatchMapping
	@RequestMapping(value = "/updateEmployee", consumes = "application/json")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		int returnValue = employeeService.updateEmployee(employee);
		if (returnValue != 0)
			return new ResponseEntity<Employee>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);

	}

	@DeleteMapping
	@RequestMapping(value = "/deleteEmployee/{employeeId}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int employeeId) {
		int returnValue = employeeService.deleteEmployee(employeeId);
		if (returnValue != 0)
			return new ResponseEntity<Employee>(HttpStatus.OK);
		else
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}

}
