package com.mastek.training.sportapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.sportapp.entities.Team;
import com.mastek.training.sportapp.repositories.TeamRepository;

//@Component: Indicate to Spring to create an object of this class as component
//@Scope: 	Singleton: one object for application
//			Prototype: one object for each usage
@Component
@Scope("prototype")
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	public TeamService() {
		System.out.println("Team Service Created");
	}
	
	public Team registerOrUpdateTeam(Team t) {
		t = teamRepository.save(t);
		System.out.println("Team Registered " + t);
		
		return t;
	}
	
	public Team findByTeamNum(int teamNum) {
		// Fetches the team details from DB by teamNum
		try {
			return teamRepository.findById(teamNum).get();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Team> fetchTeamByLocation(String loc) {
		
		return teamRepository.findByLocation(loc);
	}
	
	public void deleteByTeamNum(int teamNum) {
		
		teamRepository.deleteById(teamNum);
	}

}
