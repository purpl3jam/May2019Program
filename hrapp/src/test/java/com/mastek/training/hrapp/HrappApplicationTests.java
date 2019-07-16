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
	
//	@Test
//	public void deleteByEmpnoUsingService() {
//		int empno = 6;
//		empService.deleteByEmpno(empno);
//		assertNull(empService.findByEmpno(empno));
//	}
//	
//	@Test
//	public void checkFetchBySalary() {
//		List<Employee> emps = empService.fetchEmployeesBySalaryRange(0, 1000);
//		for (Employee employee : emps) {
//			System.out.println(employee);
//		}
//		assertEquals(emps.size(), 1);
//	}
	
	
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
	
//	@Test
//	public void deleteByDeptnoUsingService() {
//		int deptno = 2;
//		depService.deleteByDeptno(deptno);
//		assertNull(depService.findByDeptno(deptno));
//	}
//	
//	@Test
//	public void checkFetchByLocation() {
//		List<Department> deps = depService.fetchDepartmentByLocation("New Location");
//		for (Department department : deps) {
//			System.out.println(department);
//		}
//		assertEquals(deps.size(), 2);
//	}
	
	
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
	
//	@Test
//	public void deleteByProjectIdUsingService() {
//		int projectId = 2;
//		projService.deleteByProjectId(projectId);
//		assertNull(projService.findByProjectId(projectId));
//	}
//	
//	@Test
//	public void checkFetchByCustomerName() {
//		List<Project> projs = projService.fetchProjectByCustomerName("New Customer");
//		for (Project project : projs) {
//			System.out.println(project);
//		}
//		assertEquals(projs.size(),2);
//	}
	
	@Test
	public void manageAssociations() {
		Department d1 = new Department();
		d1.setName("Admin");
		d1.setLocation("UK");
		
		Employee emp1 = new Employee();
		emp1.setName("Admin Emp 1");
		emp1.setSalary(2500);
		
		Employee emp2 = new Employee();
		emp2.setName("Admin Emp 2");
		emp2.setSalary(1500);
		
		Project p1 = new Project();
		p1.setName("UK Project");
		p1.setCustomerName("UK Customer");
		
		Project p2 = new Project();
		p2.setName("US Project");
		p2.setCustomerName("US Customer");
		
		// One to Many : one Department has many Employees
		d1.getMembers().add(emp1);
		d1.getMembers().add(emp2);
		
		// Many to One for each Employee to assign the Department
		emp1.setCurrentDepartment(d1);
		emp2.setCurrentDepartment(d1);
		
		// Many to Many
		emp1.getAssignments().add(p1);
		emp1.getAssignments().add(p2);
		emp2.getAssignments().add(p1);
		
		depService.registerOrUpdateDepartment(d1);
	}
}
