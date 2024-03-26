package com.example.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entites.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
