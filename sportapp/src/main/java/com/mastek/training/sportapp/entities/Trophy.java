package com.mastek.training.sportapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Enumerated;
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
@Table(name="JPA_Trophy")
@EntityListeners({TrophyLifecycleListener.class})
@NamedQueries({@NamedQuery(name="Trophy.findByTrophyType", query="select t from Trophy t where t.trophyType = :type")})          
public class Trophy implements Serializable {
	
	@Value("-1")
	private int trophyNum;
	
	@Value("Default Trophy")
	private String trophyName;
	
	@Value("TOURNAMENT")
	private TrophyType trophyType;
	
	public Trophy() {
		System.out.println("Trophy Created");
	}

	@Id
	@Column(name="trophy_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getTrophyNum() {
		return trophyNum;
	}

	public void setTrophyNum(int trophyNum) {
		this.trophyNum = trophyNum;
	}

	@Column(name="trophy_name")
	public String getTrophyName() {
		return trophyName;
	}

	public void setTrophyName(String trophyName) {
		this.trophyName = trophyName;
	}

	@Column(name="trophy_type", nullable=false)
	@Enumerated
	public TrophyType getTrophyType() {
		return trophyType;
	}

	public void setTrophyType(TrophyType type) {
		this.trophyType = type;
	}
	
	// @ManyToMany: A Team can have many Trophies and a Trophy can have many Teams
	private Set<Team> winners = new HashSet<>();

	@ManyToMany(mappedBy="trophies")
	public Set<Team> getWinners() {
		return winners;
	}

	public void setWinners(Set<Team> winners) {
		this.winners = winners;
	}
	
	
	

}
