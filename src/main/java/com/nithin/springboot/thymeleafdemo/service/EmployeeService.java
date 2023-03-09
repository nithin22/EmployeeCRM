package com.nithin.springboot.thymeleafdemo.service;

import java.util.List;

import com.nithin.springboot.thymeleafdemo.entity.Employee;



public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theid);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theid);

}
