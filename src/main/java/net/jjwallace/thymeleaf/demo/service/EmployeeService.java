package net.jjwallace.thymeleaf.demo.service;

import java.util.List;

import net.jjwallace.thymeleaf.demo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	public void updateEmployee(Employee updateEmployee);
	public void deleteEmployee(int employeeId);
	public void addEmployee(Employee newEmployee);
	public Employee getEmployee(int employeeId);

}
