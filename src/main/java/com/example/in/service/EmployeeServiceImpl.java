package com.example.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.in.entity.Employee;
import com.example.in.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	public EmployeeRepository employeerepository;
	
//-----------------------------------------------------------------
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeerepository.save(employee);
	}
	
//--------------------------------------------------------------

	@Override
	public Optional<Employee> findById(Integer employeeid) {
		
		return employeerepository.findById(employeeid);
	}
	
//------------------------------------------------------------------
	@Override
	public void deleteEmployee(Integer employeeid) {
		employeerepository.deleteById(employeeid);
		
	}
//------------------------------------------------------------------

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeerepository.findAll();
	}
//---------------------------------------------------------
	@Override
	public Employee updateById(Integer id,Employee employee) {
		Employee emp=employeerepository.findById(id).get();
		if(emp!=null) {
			emp.setEmployeeName(employee.getEmployeeName());
			emp.setEmployeeEmail(employee.getEmployeeEmail());
			return employeerepository.save(emp);
		}
		
		return null;
	}

}
