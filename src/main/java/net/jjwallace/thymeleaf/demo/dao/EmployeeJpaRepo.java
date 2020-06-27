package net.jjwallace.thymeleaf.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.jjwallace.thymeleaf.demo.entity.Employee;

@Repository
public interface EmployeeJpaRepo extends JpaRepository<Employee, Integer> {

}
