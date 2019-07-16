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

import com.mastek.training.hrapp.apis.DepartmentService;
import com.mastek.training.hrapp.apis.EmployeeService;
import com.mastek.training.hrapp.apis.ProjectService;
import com.mastek.training.hrapp.entities.Department;
import com.mastek.training.hrapp.entities.Employee;
import com.mastek.training.hrapp.entities.Project;


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
		assertEquals(emps.size(), 1);
	}
	
	
	@Autowired
	DepartmentService depService;
	
	@Autowired
	Department dep;

	@Test
	public void addDepartmentUsingService() {
		Department dep = new Department();
		dep.setName("New Department");
		dep.setLocation("New Location");
		dep = depService.registerOrUpdateDepartment(dep);
		assertNotNull(dep);
	}
	
	@Test
	public void findByDeptnoUsingService() {
		int deptno = 15;
		assertNotNull(depService.findByDeptno(deptno));
	}
	
	@Test
	public void deleteByDeptnoUsingService() {
		int deptno = 2;
		depService.deleteByDeptno(deptno);
		assertNull(depService.findByDeptno(deptno));
	}
	
	@Test
	public void checkFetchByLocation() {
		List<Department> deps = depService.fetchDepartmentByLocation("New Location");
		for (Department department : deps) {
			System.out.println(department);
		}
		assertEquals(deps.size(), 2);
	}
	
	
	@Autowired
	ProjectService projService;
	
	@Autowired
	Project proj;
	
	@Test
	public void addProjectUsingService() {
		Project proj = new Project();
		proj.setName("New Project");
		proj.setCustomerName("New Customer");
		proj = projService.registerOrUpdateProject(proj);
		assertNotNull(proj);
	}
	
	@Test
	public void findByProjectIdUsingService() {
		int projectId = 18;
		assertNotNull(projService.findByProjectId(projectId));
	}
	
	@Test
	public void deleteByProjectIdUsingService() {
		int projectId = 2;
		projService.deleteByProjectId(projectId);
		assertNull(projService.findByProjectId(projectId));
	}
	
	@Test
	public void checkFetchByCustomerName() {
		List<Project> projs = projService.fetchProjectByCustomerName("New Customer");
		for (Project project : projs) {
			System.out.println(project);
		}
		assertEquals(projs.size(),2);
	}
}
