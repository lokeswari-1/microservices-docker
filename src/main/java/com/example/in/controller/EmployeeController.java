package com.example.in.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.in.entity.Employee;
import com.example.in.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeservice;

  
    @PostMapping("/saveemployee")
    public ResponseEntity<String> save(@RequestBody Employee employee) {
        employeeservice.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee saved with ID: " + employee.getEmployeeId());
    }

   
    

	

	
	@GetMapping("/findingall")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return new ResponseEntity<>(employeeservice.getAllEmployee(),HttpStatus.OK);
		
		
	}
	@DeleteMapping("deleteemp/{id}")
	public String deleteEmployeeById(@PathVariable Integer id){
		employeeservice.deleteEmployee(id);
		return "deleted successfully";
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateid(@PathVariable Integer id,@RequestBody Employee employee){
		return new ResponseEntity<>(employeeservice.updateById(id ,employee),HttpStatus.OK);
	}
}
