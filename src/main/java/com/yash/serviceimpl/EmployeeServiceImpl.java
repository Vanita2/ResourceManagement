package com.yash.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yash.dao.EmployeeDao;
import com.yash.model.Employee;
import com.yash.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	public int addEmployee(Employee employee) {
		int returnValue = employeeDao.addEmployee(employee);
		return returnValue;
	}

	@Transactional
	public List<Employee> getAllEmployee() {
		List<Employee> employeeList = employeeDao.getAllEmployee();
		return employeeList;
	}

	@Transactional
	public Employee getEmployeeById(int employeeId) {
		Employee employee = employeeDao.getEmployeeById(employeeId);
		return employee;
	}

	@Transactional
	public int updateEmployee(Employee employee) {
		int returnValue = employeeDao.updateEmployee(employee);
		return returnValue;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteEmployee(int employeeId) {
		int returnValue = employeeDao.deleteEmployee(employeeId);
		return returnValue;
	}

}
