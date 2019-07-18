package com.mastek.training.hrapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="JPA_Project")
@EntityListeners({ProjectLifecycleListener.class})
@NamedQueries({@NamedQuery(name="Project.findByCustomer",query="select p from Project p where p.customerName = :cus")})
public class Project {
	
	@Value("-1")
	private int projectId;
	
	@Value("New Project")
	private String name;
	
	@Value("New Customer")
	private String customerName;
	
	public Project() {
		System.out.println("Project Created");
	}

	@Id
	@Column(name="project_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	

	private Set<Employee> team = new HashSet<>();
	
	// mappedBy: check the configuration for Many to Many association in Employee class getAssignments() method
	@ManyToMany(mappedBy="assignments")
	@XmlTransient
	public Set<Employee> getTeam() {
		return team;
	}

	public void setTeam(Set<Employee> team) {
		this.team = team;
	}
	

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", customerName=" + customerName + "]";
	}

}
