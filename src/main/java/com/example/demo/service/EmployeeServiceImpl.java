package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEmployeeDAO;
import com.example.demo.entity.NewEmployee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDAO dao;

	@Override
	public String registerEmployee(NewEmployee employee) throws Exception {
		
		if(dao.addEmployee(employee)==null) {
			return "Failed to Add Employee Details";
		}
		return "Successfully Added";
	}

	@Override
	public List<NewEmployee> selectEmployee(NewEmployee employee) throws Exception {
		return dao.checkEmployee(employee);
	}

	@Override
	public String removeEmployee(NewEmployee employee) throws Exception {
		return dao.deleteEmployee(employee);
	}

	@Override
	public String changeEmployee(NewEmployee employee) throws Exception {
		return dao.updateEmployee(employee);
	}

}
