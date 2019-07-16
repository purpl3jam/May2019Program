package com.mastek.training.hrapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class ProjectLifecycleListener {
	
	@PrePersist
	public void beforeInsert(Project p) {
		System.out.println("Before Insert: " + p);
	}
	
	@PostPersist
	public void afterInsert(Project p) {
		System.out.println("After Insert: " + p);
	}
	
	@PreUpdate
	public void beforeUpdate(Project p) {
		System.out.println("Before Update: " + p);
	}
	
	@PostUpdate
	public void afterUpdate(Project p) {
		System.out.println("After Update: " + p);
	}
	
	@PreRemove
	public void beforeDelete(Project p) {
		System.out.println("Before Delete: " + p);
	}
	
	@PostLoad
	public void afterSelect(Project p) {
		System.out.println("After Select: " + p);
	}

}
