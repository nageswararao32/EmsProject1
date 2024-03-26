package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entites.Employee;

public interface EmployeeService {

	public void addEmployee(Employee emp);

	public List<Employee> getEmployees();

	public Optional<Employee> findEmployeeById(Long id);

	public Employee updateEmployee(Long id, Employee employeeDetails);

	public void deleteEmployee(Long id);
	
	

}
