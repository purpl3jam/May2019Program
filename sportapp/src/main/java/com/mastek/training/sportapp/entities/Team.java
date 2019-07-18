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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // One copy for each test case
@Entity // Declares the class as an entity
@Table(name="JPA_Team") // Declaring the table name for the class
@EntityListeners({TeamLifecycleListener.class})
@NamedQueries({@NamedQuery(name="Team.findByLocation", query="select t from Team t where t.location = :loc")})
public class Team implements Serializable {

	@Value("-1")
	private int teamNum;
	
	@Value("Default Team")
	private String name;
	
	@Value("Default Location")
	private String location;
	
	public Team() {
		System.out.println("Team Created");
	}

	@Id // Declare the property as Primary Key
	@Column(name="team_number") // Declare the name of the column
	@GeneratedValue(strategy=GenerationType.AUTO) // Auto-numbering
	public int getTeamNum() {
		return teamNum;
	}

	public void setTeamNum(int teamNum) {
		this.teamNum = teamNum;
	}

	@Column(name="team_name", nullable=false, length=45)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="location", nullable=false)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	// @OneToMany: One Team has many Players
	private Set<Player> players = new HashSet<>();

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="currentTeam")
	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	
	private Set<Trophy> trophies = new HashSet<>();

	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="JPA_WINNERS", joinColumns=@JoinColumn(name="FK_TEAMNUM"), inverseJoinColumns=@JoinColumn(name="FK_TROPHYID"))
	public Set<Trophy> getTrophies() {
		return trophies;
	}

	public void setTrophies(Set<Trophy> trophies) {
		this.trophies = trophies;
	}
	
	@Override
	public String toString() {
		return "Team [teamNum=" + teamNum + ", name=" + name + ", location=" + location + "]";
	}
	
	
	
}
