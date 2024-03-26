package com.example.demo.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;
	
	private String name;
	
	private int age;
	
	private String email;
	
	private String designation;
		
	private double salary;
	
	private String address;
	
	public Employee() {
		
		super();
	}

	public Employee(long id, String name, int age, String email, String designation, double salary, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.designation = designation;
		this.salary = salary;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", designation="
				+ designation + ", salary=" + salary + ", address=" + address + "]";
	}

	
}
