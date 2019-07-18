package com.mastek.training.sportapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class TeamLifecycleListener {
	
	// life-cycle methods
	// @<Event>
	// public void <name>(Entity e)

	@PrePersist
	public void beforeInsert(Team t) {
		System.out.println("Before Insert: " + t);
	}
	
	@PostPersist
	public void afterInsert(Team t) {
		System.out.println("After Insert: " + t);
	}
	
	@PreUpdate
	public void beforeUpdate(Team t) {
		System.out.println("Before Update: " + t);
	}
	
	@PostUpdate
	public void afterUpdate(Team t) {
		System.out.println("After Update: " + t);
	}
	
	@PreRemove
	public void beforeDelete(Team t) {
		System.out.println("Before Delete: " + t);
	}
	
	@PostLoad
	public void afterSelect(Team t) {
		System.out.println("After Select: " + t);
	}
	
}
