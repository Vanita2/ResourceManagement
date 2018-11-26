package com.yash.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.dao.EmployeeDao;
import com.yash.model.EducationDetail;
import com.yash.model.Employee;
import com.yash.model.Skill;
import com.yash.model.WorkExperience;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public int addEmployee(Employee employee) {
		try {
			employee.setDeleted(false);
			sessionFactory.getCurrentSession().saveOrUpdate(employee);
			List<EducationDetail> educationList = employee.getEducationDetails();
			for (EducationDetail educationDetail : educationList) {
				sessionFactory.getCurrentSession().saveOrUpdate(educationDetail);
			}
			List<Skill> skillList = employee.getSkills();
			for (Skill skill : skillList) {
				sessionFactory.getCurrentSession().saveOrUpdate(skill);
			}
			List<WorkExperience> workExpList = employee.getWorkExperiences();
			for (WorkExperience workExperience : workExpList) {
				sessionFactory.getCurrentSession().saveOrUpdate(workExperience);
			}
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {
		try {
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			List<Employee> employeeList = (List<Employee>) criteria.list();
			return employeeList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Employee getEmployeeById(int employeeId) {
		try {
			/*
			 * Session session = sessionFactory.openSession(); Criteria criteria
			 * = session.createCriteria(Employee.class);
			 * criteria.add(Restrictions.eq("employeeId", employeeId)); Employee
			 * employee = (Employee) criteria.uniqueResult();
			 */

			Employee employee = (Employee) sessionFactory.getCurrentSession().get(Employee.class, employeeId);
			return employee;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public int updateEmployee(Employee employee) {
		try {
			sessionFactory.getCurrentSession().update(employee);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public int deleteEmployee(int employeeId) {
		try {
			sessionFactory.getCurrentSession().delete(getEmployeeById(employeeId));
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

}
