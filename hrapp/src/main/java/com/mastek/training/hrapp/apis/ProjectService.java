package com.mastek.training.hrapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.hrapp.entities.Project;
import com.mastek.training.hrapp.repositories.ProjectRepository;

@Component
@Scope("prototype")
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public ProjectService() {
		System.out.println("Project Service Created");
	}
	
	public Project registerOrUpdateProject(Project proj) {
		proj = projectRepository.save(proj);
		System.out.println("Project Registere" + proj);
		return proj;
	}
	
	public Project findByProjectId(int projectId) {
		try {
			return projectRepository.findById(projectId).get();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Project> fetchProjectByCustomerName(String cus) {
		
		return projectRepository.findByCustomerName(cus);
	}
	
	public void deleteByProjectId(int projectId) {
		projectRepository.deleteById(projectId);
	}
}
