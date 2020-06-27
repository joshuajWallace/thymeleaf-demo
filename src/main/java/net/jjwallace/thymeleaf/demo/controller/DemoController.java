package net.jjwallace.thymeleaf.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.jjwallace.thymeleaf.demo.entity.Employee;
import net.jjwallace.thymeleaf.demo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class DemoController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		List<Employee> employees = employeeService.getEmployees();
		model.addAttribute("employees", employees);
		return "employees/employees";
	}
	
	@GetMapping("/list/{employeeId}")
	public String showEmployee(@PathVariable int employeeId, Model model) {
		Employee employee = employeeService.getEmployee(employeeId);
		model.addAttribute("employee", employee);
		return "employees/employee";
	}
	
	@GetMapping("/addEmployeeForm")
	public String addEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/add-form";
	}
	@GetMapping("/update")
	public String updateForm(@RequestParam(name="employeeId") int employeeId, Model model) {
		Employee employee = employeeService.getEmployee(employeeId);
		model.addAttribute("employee", employee);		
		return "employees/update";
	}
	@GetMapping("/delete/{employeeId}")
	public String redirectDeleteEmployee(@PathVariable int employeeId, Model model) {
		employeeService.deleteEmployee(employeeId);
		return "redirect:/employees/list";
	}
	
	@PostMapping("/save")
	public String postEmployee(@ModelAttribute("employee") Employee newEmployee) {
		employeeService.addEmployee(newEmployee);
		return "redirect:/employees/list";
	}
	@PostMapping("/update")
	public String putEmployee(@ModelAttribute("employee") Employee updateEmployee) {
		employeeService.updateEmployee(updateEmployee);
		return "redirect:/employees/list";
	}

}
