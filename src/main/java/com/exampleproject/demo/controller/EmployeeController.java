package com.exampleproject.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.exampleproject.demo.model.Employee;
import com.exampleproject.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	
	@Autowired
private EmployeeService service;

	@RequestMapping("/welcome")
	public String welcome() {
		return "lets see if it run";
	}
	
	@GetMapping("/employees/{id}")
    public Employee retrieveEmployeeDetails(@PathVariable int id) {
        return service.retrieveEmployee(id);
    }
	
	@GetMapping("/employees")
    public List<Employee> retrieveAllEmployeeDetails() {
        return service.retrieveAllEmployees();
    }
//	@PostMapping("/employees")
//	public  String createEmployee(@RequestParam int id,@RequestParam String name) {
//		Employee employee=new Employee(id,name);
//	     service.addEmployees(employee);
//	     return "Record is added";
//	}
	@PostMapping("/employees")
	public  String createEmployee(@RequestBody Employee employee) {
	     service.addEmployees(employee);
	     return "Record is added";
	}
	@PutMapping("/employees/{id}")
	public List<Employee> updateEmployees(@PathVariable int id,@RequestParam String name)
	{
		service.updateNameEmployee(id, name);
		return service.retrieveAllEmployees();
	}
	@DeleteMapping("/employees/id")
	public String deleteEmployees(@PathVariable int d)
	{
		String str="";
		int test=service.deleteASpecificEmployee(d);
		if(test==1)
		{
			str="The record is successfully deleted";
		}else {
			str="The record is not found";
		}
	return str;
	}
}