package com.example.demo.runner;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.controller.EmployeeController;
import com.example.demo.entity.NewEmployee;

@Component
public class EmployeeRunner implements ApplicationRunner {

	@Autowired
	private EmployeeController controller;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Scanner sc = new Scanner(System.in);

		NewEmployee emp = new NewEmployee();
		
		int id=0;
		String name="";
		double salary=0.0;
		String addr="";
		
		String msg="";
		
		System.out.println("1. ADD    Employee");
		System.out.println("2. CHECK  Employee");
		System.out.println("3. REMOVE Employee");
		System.out.println("4. UPDATE Employee");

		System.out.println("Enter Your Choice :: ");
		int choice = sc.nextInt();

		switch (choice) {
			case 1:
				System.out.println("Enter Employee ID :: ");
				id = sc.nextInt();
	
				sc.nextLine();
	
				System.out.println("Enter Employee Name :: ");
				name = sc.nextLine();
	
				System.out.println("Enter Employee Salary :: ");
				salary = sc.nextDouble();
	
				sc.nextLine();
	
				System.out.println("Enter Employee Address :: ");
				addr = sc.nextLine();
	
				
				emp.setEmpId(id);
				emp.setEmpName(name);
				emp.setEmpSal(salary);
				emp.setEmpAddr(addr);
				
				try {
					msg = controller.add(emp);
					System.out.println(msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 2:
				sc.nextLine();
				
				System.out.println("Enter the name of Employee :: ");
				name=sc.nextLine();
				
				emp.setEmpName(name);
				
				try {
					
					List<NewEmployee>list=controller.check(emp);
					for(NewEmployee e : list) {
						System.out.println("Employee ID      :: "+ e.getEmpId());
						System.out.println("Employee NAME    :: "+ e.getEmpName());
						System.out.println("Employee SALARY  :: "+ e.getEmpSal());
						System.out.println("Employee Address :: "+ e.getEmpAddr());
						System.out.println("====================================");
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Enter the Employee ID :: ");
				id=sc.nextInt();
				
				emp.setEmpId(id);
				try {
					msg=controller.remove(emp);
					System.out.println(msg);
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 4:
				System.out.println("Enter the Employee ID :: ");
				id=sc.nextInt();
				
				sc.nextLine();
				
				System.out.println("Enter the New Name of Employee :: ");
				name=sc.nextLine();
				
				emp.setEmpId(id);
				emp.setEmpName(name);
				
				try {
					msg=controller.update(emp);
					System.out.println(msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		}
	
		if (sc != null)
			sc.close();

	}

}
