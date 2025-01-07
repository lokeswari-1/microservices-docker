package com.example.in.service;

import java.util.List;
import java.util.Optional;

import com.example.in.entity.Employee;

public interface IEmployeeService {
	public Employee saveEmployee(Employee employee) ;
	public Optional<Employee> findById(Integer employeeid);
	public void deleteEmployee(Integer employeeid);
	public List<Employee> getAllEmployee();
	
public Employee updateById(Integer id,Employee employee);

}
