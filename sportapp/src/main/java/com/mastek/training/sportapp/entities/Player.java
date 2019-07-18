package com.mastek.training.sportapp.entities;

import java.io.Serializable;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="JPA_Player")
@EntityListeners({PlayerLifecycleListener.class})
@NamedQueries({@NamedQuery(name="Player.findByAge", query="select p from Player p where p.age = :age")})
public class Player implements Serializable {
	
	@Value("-1")
	private int playNum;
	
	@Value("Default Name")
	private String name;
	
	@Value("20")
	private int age;
	
	public Player() {
		System.out.println("Player Created");
	}

	@Id
	@Column(name="player_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getPlayNum() {
		return playNum;
	}

	public void setPlayNum(int playNum) {
		this.playNum = playNum;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	// @ManyToOne: Each player belongs to one Team
	private Team currentTeam;

	@ManyToOne
	@JoinColumn(name="FK_TeamID")
	public Team getCurrentTeam() {
		return currentTeam;
	}

	public void setCurrentTeam(Team currentTeam) {
		this.currentTeam = currentTeam;
	}
	
	
	
}
