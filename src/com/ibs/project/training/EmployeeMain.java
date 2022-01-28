package com.ibs.project.training;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class EmployeeMain {

	public static void main(String[] args) {
		
		
		List <Employee> employee = Arrays.asList(
				
				new Employee("A-10563","Rashad",1001,"active","25000"),
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
		
		empByDep.entrySet().forEach(entry->{
			System.out.println(entry.getKey()+":"+entry.getValue());
		}); 
		
		
		// Employee Count in each Department
		
		 System.out.println("\nEmployees count working in each department:");
	      
	      Map<Integer, Long> empCount = employee.stream().collect(
	                Collectors.groupingBy(Employee::getDepId, Collectors.counting()));
	      System.out.println(empCount);
	      
	   // Active and Inactive employees
	      
	      Long activeEmployee = employee.stream().filter(e->"active".equals(e.getStatus())).count();
	      Long inactiveEmployee = employee.stream().filter(e->"inactive".equals(e.getStatus())).count();
	      
	      System.out.println("\nActive Employee:"+ activeEmployee);
	      System.out.println("Inactive Employee:"+ inactiveEmployee);
	      
	   // Min and Max Salary of Employee 
	      
	     Optional<Employee> maxSalary = employee.stream().max(Comparator.comparing(Employee::getSalary));
	     Optional<Employee> minSalary =  employee.stream().min(Comparator.comparing(Employee::getSalary));
	     
	     System.out.println(maxSalary);
	     System.out.println(minSalary);
	     
	     System.out.println();
	 // Max salary of employee from each department
	      
	     Map<Integer, Optional<Employee>> maxSalaryOfDep = employee.stream().collect(Collectors.groupingBy(Employee::getDepId,
	    		 Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))
	    		 ));
	     
	     maxSalaryOfDep.entrySet().forEach(entry->{
				System.out.println(entry.getKey()+":"+entry.getValue());
			});

	}

}
