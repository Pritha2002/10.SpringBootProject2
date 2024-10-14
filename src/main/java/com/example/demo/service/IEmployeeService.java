package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.NewEmployee;

public interface IEmployeeService {
	public String registerEmployee(NewEmployee employee) throws Exception;
	public List<NewEmployee> selectEmployee(NewEmployee employee) throws Exception;
	public String removeEmployee(NewEmployee employee) throws Exception;
	public String changeEmployee(NewEmployee employee) throws Exception;
}
