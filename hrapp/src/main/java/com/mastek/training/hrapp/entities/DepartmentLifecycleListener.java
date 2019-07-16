package com.mastek.training.hrapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class DepartmentLifecycleListener {
	
	@PrePersist
	public void beforeInsert(Department d) {
		System.out.println("Before Insert: " + d);
	}
	
	@PostPersist
	public void afterInsert(Department d) {
		System.out.println("After Insert: " + d);
	}
	
	@PreUpdate
	public void beforeUpdate(Department d) {
		System.out.println("Before Update: " + d);
	}
	
	@PostUpdate
	public void afterUpdate(Department d) {
		System.out.println("After Update: " + d);
	}
	
	@PreRemove
	public void beforeDelete(Department d) {
		System.out.println("Before Delete: " + d);
	}
	
	@PostLoad
	public void afterSelect(Department d) {
		System.out.println("After Select: " + d);
	}

}
