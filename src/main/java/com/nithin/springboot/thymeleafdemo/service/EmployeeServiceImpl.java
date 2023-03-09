package com.nithin.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nithin.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.nithin.springboot.thymeleafdemo.entity.Employee;




@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository=theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	
	public Employee findById(int theid) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeRepository.findById(theid);
		
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee=result.get();
		}
		
		else
		{
			throw new RuntimeException("Cannot find the employee id "+theid);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		System.out.println("########################");
		System.out.println(theEmployee.getFirstName());
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theid) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(theid);

	}

}
