package com.yash.service;

import java.util.List;

import com.yash.model.Employee;

public interface EmployeeService {

	public int addEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public Employee getEmployeeById(int employeeId);

	public int updateEmployee(Employee employee);

	public int deleteEmployee(int employeeId);

}
