package com.example.demo.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class NewEmployee {

	private Integer empId;
	private String empName;
	private Double empSal;
	private String empAddr;
	
}
