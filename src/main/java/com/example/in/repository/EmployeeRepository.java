package com.example.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.in.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	

}
