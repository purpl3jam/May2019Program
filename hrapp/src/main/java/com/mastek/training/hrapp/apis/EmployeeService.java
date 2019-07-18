package com.mastek.training.hrapp.apis;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.hrapp.entities.Employee;
import com.mastek.training.hrapp.repositories.EmployeeRepository;


// @Component: Indicate to Spring to create an object of this class as component
// @Scope: 	Singleton: one object for application
//			Prototype: one object for each usage
// @Path: Map the URL pattern with the class as service
@Component
@Scope("singleton")
@Path("/employees")
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeService() {
		System.out.println("Employee Service Created");
	}
	
	
	@Path("/register") // URL Pattern
	@POST // HTTP Method to send the form Data
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) // Form data
	@Produces(MediaType.APPLICATION_JSON) // JSON data
	public Employee registerOrUpdateEmployee(
			@BeanParam Employee emp) { // Input Bean using form
		System.out.println(emp.getName());
		emp = employeeRepository.save(emp);
		System.out.println("Employee Registered " + emp);
		
		return emp;
	}

	// @Path: Use find method using PathParam
	// /find/1234 : 1234->empno to pass as param to this method
	// @GET: HTTP method used to call the api
	// @Produces: Declare all possible content types of return value
	@Path("/find/{empno}")
	@GET
	@Produces({
		MediaType.APPLICATION_JSON, // Object to be given in JSON 
		MediaType.APPLICATION_XML // Object to be given in XML
		})
	public Employee findByEmpno(@PathParam("empno") int empno) {
		// Fetches the employee details from DB by empno
		try {
			return employeeRepository.findById(empno).get();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Employee> fetchEmployeesBySalaryRange(double min, double max) {
		return employeeRepository.findBySalary(min, max);
	}

	public void deleteByEmpno(int empno) {
		
		employeeRepository.deleteById(empno);
	}

}
