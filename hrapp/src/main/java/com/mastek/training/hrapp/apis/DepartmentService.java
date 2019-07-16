package com.mastek.training.hrapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.hrapp.entities.Department;
import com.mastek.training.hrapp.repositories.DepartmentRepository;

@Component
@Scope("prototype")
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public DepartmentService() {
		System.out.println("Department Service Created");
	}
	
	public Department registerOrUpdateDepartment(Department dep) {
		dep = departmentRepository.save(dep);
		System.out.println("Department Registered" + dep);
		return dep;
	}
	
	public Department findByDeptno(int deptno) {
		try {
			return departmentRepository.findById(deptno).get();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Department> fetchDepartmentByLocation(String loc) {
	
		return departmentRepository.findByLocation(loc);
	}
	
	public void deleteByDeptno(int deptno) {
		
		departmentRepository.deleteById(deptno);
	}

}
