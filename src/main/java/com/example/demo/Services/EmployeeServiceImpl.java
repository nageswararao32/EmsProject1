package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entites.Employee;
import com.example.demo.Repos.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	
	EmployeeRepo employeeRepository;
	
	@Override
	public void addEmployee(Employee emp) {
		
		employeeRepository.save(emp);
		
	}

	@Override
	public List<Employee> getEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setDesignation(employeeDetails.getDesignation());
        employee.setAddress(employeeDetails.getAddress());
        employee.setAge(employeeDetails.getAge());
        employee.setSalary(employeeDetails.getSalary());
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.delete(employee);
    }

	

}
