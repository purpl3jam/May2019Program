package com.mastek.training.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="JPA_Department")
@EntityListeners({DepartmentLifecycleListener.class})
@NamedQueries({@NamedQuery(name="Department.findBySalary",query="select d from Department d where d.location = :loc")})
public class Department {
	
	@Value("-1")
	private int deptno;
	
	@Value("Default Department")
	private String name;
	
	@Value("Default Location")
	private String location;

	
	public Department() {
		System.out.println("Department Created");
	}

	
	@Id
	@Column(name="department_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	// @OneToMany: One Department has many Employees
	private Set<Employee> members = new HashSet<>();
	
	// @OneToMany: used on the get method of set to configure association
	// fetch=	LAZY: delay the initialisation until method getMembers is called using additional select query [default value]
	//			EAGER: initialise the collection on entity find Post load event
	// cascade=	ALL the Entity operations done on Department would be performed on each associated Employee object
	//			ALL: [Persist, Merge, Delete, Refresh]
	// mappedBy: 	identifies the property name in Child class where the JoinColumn configuration is present
	// 				JoinColumn::ForeignKey
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="currentDepartment")
	@XmlTransient
	public Set<Employee> getMembers() {
		return members;
	}

	public void setMembers(Set<Employee> members) {
		this.members = members;
	}
	
	
	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", name=" + name + ", location=" + location + "]";
	}
	
}
