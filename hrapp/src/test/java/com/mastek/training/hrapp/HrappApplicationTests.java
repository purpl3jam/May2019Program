package com.mastek.training.hrapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.EmployeeService;
import com.mastek.training.hrapp.entities.Employee;


// Initialise the JUnit Test with Spring Boot Application Environment
// Spring Boot Test: used to test Spring ApplicationContext with all the test cases identified

@RunWith(SpringRunner.class)
@SpringBootTest
public class HrappApplicationTests {
	
	// Scan in memory all the components and provide the best match object in the component
	@Autowired
	EmployeeService empService;
	
	@Autowired
	Employee emp;
	
	@Test
	public void addEmployeeUsingService() {
		Employee emp = new Employee();
		emp.setEmpno(5);
		emp.setName("New Employee 5");
		emp.setSalary(999);
		emp = empService.registerOrUpdateEmployee(emp);
		assertNotNull(emp);
	}
	
//	@Test
//	public void addNewEmployeeUsingService() {
//		Employee emp = new Employee();
//		emp.setEmpno(13534);
//		emp.setName("Example");
//		emp.setSalary(2000);
//		empService.registerEmployee(emp);
//	}
	
	@Test
	public void findByEmpnoUsingService() {
		int empno = 1;
		assertNotNull(empService.findByEmpno(empno));
	}
	
	@Test
	public void deleteByEmpnoUsingService() {
		int empno = 6;
		empService.deleteByEmpno(empno);
		assertNull(empService.findByEmpno(empno));
	}
	
	@Test
	public void checkFetchBySalary() {
		List<Employee> emps = empService.fetchEmployeesBySalaryRange(0, 1000);
		for (Employee employee : emps) {
			System.out.println(employee);
		}
		assertEquals(emps.size(), 2);
	}

	@Test
	public void simpleTest() {
		System.out.println("System Test Executed");
	}

}
