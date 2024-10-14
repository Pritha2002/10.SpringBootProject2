package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.NewEmployee;

public interface IEmployeeDAO {
	public NewEmployee addEmployee(NewEmployee employee) throws Exception;
	public List<NewEmployee> checkEmployee(NewEmployee employee) throws Exception;
	public String deleteEmployee(NewEmployee employee) throws Exception;
	public String updateEmployee(NewEmployee employee) throws Exception;
}
