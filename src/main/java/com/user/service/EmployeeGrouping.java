package com.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

class Employee {
	
	private String name;
	private int age;
	
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "Employee{name=" + this.name + ", age=" + this.age + "}" ;
	}
	
	
}

public class EmployeeGrouping {
	
	public static void main(String[] args) {
		
		List<Employee> emp = Arrays.asList(
				new Employee("mohan", 31),
				new Employee("mohan-wife", 32),
				new Employee("mohan-grandma", 81),
				new Employee("mohan-father", 61),
				new Employee("mohan-son", 2)
		);
		
		Map<String, List<Employee>> empAgeIndex = new HashMap<>();
		emp.forEach(e -> {
			int age = e.getAge();
			
			String groupingKey = null;
			if (age >=30 && age <= 50)  {
				groupingKey = "30-50";
			} else if (age >= 60 && age <= 70) {
				groupingKey = "60-70";
			} else if (age >= 80 && age <= 90) {
				groupingKey = "80-90";
			} 
			List<Employee> empls = null;
			if (!empAgeIndex.containsKey(groupingKey)) {
				empls = new ArrayList<>();
			} else {
				empls = empAgeIndex.get(groupingKey);
			}
			empls.add(e);
			empAgeIndex.put(groupingKey, empls);
			
		});
		
//		Map<String, List<Employee>> empAgeIndex = emp.stream().filter(e -> e.getAge() >= 30).collect(
//				Collectors.groupingBy(e -> {
//					
//					int age = e.getAge();
//					if (age >= 30 && age <=50) return "30-50";
//					if (age >= 60 && age <= 70) return "60-70";
//					if (age >= 80 && age <= 90) return "80-90";
//					return "Others";
//				})
//		);
		
		empAgeIndex.remove(null);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		List<Future<?>> futures = new ArrayList<>();
		
		empAgeIndex.forEach((key, value) -> {
			
			futures.add(executor.submit(() -> {
				System.out.println(key+ value);	
			}));
		});
		
		empAgeIndex.entrySet().parallelStream().forEach((entry) -> {
			
			futures.add(executor.submit(() -> {
				System.out.println(entry.getKey()+ entry.getValue());	
			}));
		});
		
		
		
//		ExecutorService executorService = Executors.newFixedThreadPool(5);
//		List<Future<?>> futures = new ArrayList<>();
//		empAgeIndex.forEach((key, value) -> {
//			futures.add(executorService.submit(() -> {
//				System.out.println(key+ value);	
//			}));
//		});
//		
		for (Future<?> future : futures) {
			 try {
				 future.get();
			 } catch (Exception e) {
				 
			 }
		}
//		
//		// Shutdown executor
		executor.shutdown();
        System.out.println("Processing complete.");
        
//		empAgeIndex.entrySet().forEach(e -> {
//			System.out.println( e.getKey()+ e.getValue());
//		}) ;
	}
	
}