package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.NewEmployee;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public NewEmployee addEmployee(NewEmployee employee) throws Exception {
		
		String query="INSERT INTO NEWEMPLOYEE VALUES(? ,? ,? ,?)";
		if(jdbcTemplate.update(query,employee.getEmpId(),employee.getEmpName(),employee.getEmpSal(),employee.getEmpAddr())==0)
		{
			return null;
		}
		
		return employee;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<NewEmployee> checkEmployee(NewEmployee employee) throws Exception {
	    
	    String empQuery = "SELECT * FROM newemployee WHERE empName = ?";

	    RowMapper<NewEmployee> mapper = new RowMapper<NewEmployee>() {
	        @Override
	        public NewEmployee mapRow(ResultSet rs, int rowNum) throws SQLException {
	            NewEmployee newEmployee = new NewEmployee();
	            newEmployee.setEmpId(rs.getInt("empId"));           
	            newEmployee.setEmpName(rs.getString("empName"));  
	            newEmployee.setEmpSal(rs.getDouble("empSal"));
	            newEmployee.setEmpAddr(rs.getString("empAddr"));
	            return newEmployee;
	        }
	    };

	    return jdbcTemplate.query(empQuery, new Object[]{employee.getEmpName()}, mapper);
	}

	@Override
	public String deleteEmployee(NewEmployee employee) throws Exception {
		String query="DELETE FROM newemployee WHERE empid=?";
		
		if(jdbcTemplate.update(query,employee.getEmpId())==0) {
			return "Employee ID not found";
		}
		
		return "Employee Removed Successfully";
	}

	@Override
	public String updateEmployee(NewEmployee employee) throws Exception {
		String query="update newemployee set empname=? where empid=?";
		
		if(jdbcTemplate.update(query,employee.getEmpName(),employee.getEmpId())==0) {
			return "Failed";
		}
		return "Updated Successfully";
	}


}
