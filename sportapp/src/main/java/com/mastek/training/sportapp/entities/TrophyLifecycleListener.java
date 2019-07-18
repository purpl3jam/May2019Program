package com.mastek.training.sportapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class TrophyLifecycleListener {
	
	@PrePersist
	public void beforeInsert(Trophy t) {
		System.out.println("Before Insert: " + t);
	}
	
	@PostPersist
	public void afterInsert(Trophy t) {
		System.out.println("After Insert: " + t);
	}
	
	@PreUpdate
	public void beforeUpdate(Trophy t) {
		System.out.println("Before Update: " + t);
	}
	
	@PostUpdate
	public void afterUpdate(Trophy t) {
		System.out.println("After Update: " + t);
	}
	
	@PreRemove
	public void beforeDelete(Trophy t) {
		System.out.println("Before Delete: " + t);
	}
	
	@PostLoad
	public void afterSelect(Trophy t) {
		System.out.println("After Select: " + t);
	}

}
