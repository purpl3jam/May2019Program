package com.mastek.training.sportapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class PlayerLifecycleListener {
	
	@PrePersist
	public void beforeInsert(Player p) {
		System.out.println("Before Insert: " + p);
	}
	
	@PostPersist
	public void afterInsert(Player p) {
		System.out.println("After Insert: " + p);
	}
	
	@PreUpdate
	public void beforeUpdate(Player p) {
		System.out.println("Before Update: " + p);
	}
	
	@PostUpdate
	public void afterUpdate(Player p) {
		System.out.println("After Update: " + p);
	}
	
	@PreRemove
	public void beforeDelete(Player p) {
		System.out.println("Before Delete: " + p);
	}
	
	@PostLoad
	public void afterSelect(Player p) {
		System.out.println("After Select: " + p);
	}

}
