package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.NewEmployee;
import com.example.demo.service.IEmployeeService;

@Controller 
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	public String add(NewEmployee employee) throws Exception {
		return service.registerEmployee(employee);
		
	}
	
	public List<NewEmployee> check(NewEmployee employee) throws Exception {
		return service.selectEmployee(employee);
	}
	
	public String remove(NewEmployee employee) throws Exception {
		return service.removeEmployee(employee);
	}
	
	public String update(NewEmployee employee) throws Exception {
		return service.changeEmployee(employee);
	}
}
