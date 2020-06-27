package net.jjwallace.thymeleaf.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.jjwallace.thymeleaf.demo.dao.EmployeeJpaRepo;
import net.jjwallace.thymeleaf.demo.entity.Employee;

@Transactional
@Repository
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeJpaRepo repository;
	
	@Override
	public List<Employee> getEmployees() {
		return repository.findAll();
	}

	@Override
	public void updateEmployee(Employee updateEmployee) {
		repository.save(updateEmployee);
	}
	@Override
	public void deleteEmployee(int employeeId) {
		repository.deleteById(employeeId);
		
	}

	@Override
	public void addEmployee(Employee newEmployee) {
		repository.save(newEmployee);		
	}

	@Override
	public Employee getEmployee(int employeeId) {
		return repository.getOne(employeeId);
	}

}
