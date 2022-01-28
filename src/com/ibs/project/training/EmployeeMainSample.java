package com.ibs.project.training;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeMainSample {

	public static void main(String[] args) {
		
		List <Employee> employee = Arrays.asList(
				
				new Employee("A-10563","Rashad",1001,"active","22000"),
				new Employee ("A-10574", "John",1003,"active","26000"),
				new Employee ("A-10580", "David",1001,"inactive","25000"),
				new Employee ("A-10022", "Ashin",1002,"active","30000"),
				new Employee ("A-10510", "Shabeer",1003,"active","27000"),
				new Employee ("A-10560", "Adam",1002,"inactive","24000"),
				new Employee ("A-10566", "Sam",1001,"active","25600")
				);
		
		
		// details of all employees in each department
		  Map<Integer, List<Employee>> empByDep  = employee.stream()
	      .collect(Collectors.groupingBy(Employee::getDepId));
	      
	      System.out.println("Employee Details in each Department: "+  empByDep);
	      
	      
	      
	   // Employee Count in each Department
	      System.out.println("\nEmployees count working in each department:");
	      
	      Map<Integer, Long> empCount = employee.stream().collect(
	                Collectors.groupingBy(Employee::getDepId, Collectors.counting()));
	      System.out.println(empCount);
	      
	      
	      
	   // Active and Inactive employees   
	      System.out.println("\nActive and inactive employees in the given collection:");
	      
	      Map<String, List<Employee>> status = employee.stream().collect(
	                Collectors.groupingBy(Employee::getStatus));
	      System.out.println(status);
	      
	      
	   
	   // Min and Max Salary of Employee  
	      System.out.println("\nMax/Min Salary from the given collection:");
	      Comparator<Employee> comparator = Comparator.comparing( Employee::getSalary );
	      
	      String minSalary = employee.stream().min(comparator).get().getSalary();
	      String maxSalary = employee.stream().max(comparator).get().getSalary();
	      System.out.println("Employee With Min Salary = " + minSalary);
	      System.out.println("Employee With Max Salary = " + maxSalary);
	      
	      
	      
	   // Max salary of employee from each department
	      System.out.println("\nMax salary of an employee from each department");
	      
	      Map<Integer, List<Employee>> deptMaxSalary = employee.stream()
	    		.collect(Collectors.groupingBy(Employee::getDepId));
	      System.out.println(deptMaxSalary);


	}

}
