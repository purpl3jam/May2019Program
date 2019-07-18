package com.mastek.training.sportapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.sportapp.apis.PlayerService;
import com.mastek.training.sportapp.apis.TrophyService;
import com.mastek.training.sportapp.apis.TeamService;
import com.mastek.training.sportapp.entities.Player;
import com.mastek.training.sportapp.entities.Team;
import com.mastek.training.sportapp.entities.Trophy;
import com.mastek.training.sportapp.entities.TrophyType;

//Initialise the JUnit Test with Spring Boot Application Environment
//Spring Boot Test: used to test Spring ApplicationContext with all the test cases identified
@RunWith(SpringRunner.class)
@SpringBootTest
public class SportappApplicationTests {

	// Scan in memory all the components and provide the best match object in the component
	@Autowired
	Team team;
	
	@Autowired
	TeamService teamService;
	
//	@Test
//	public void addTeamUsingService() {
//		Team t = new Team();
//		t.setName("Newcastle United");
//		t.setLocation("Newcastle");
//		t = teamService.registerOrUpdateTeam(t);
//		assertNotNull(t);
//	}
	
	@Test 
	public void findByTeamNumUsingService() {
		int teamNum = 57;
		assertNotNull(teamService.findByTeamNum(teamNum));
	}
	
//	@Test
//	public void deleteByTeamNumUsingService() {
//		int teamNum = 5;
//		teamService.deleteByTeamNum(teamNum);
//		assertNull(teamService.findByTeamNum(teamNum));
//	}
	
	@Test
	public void checkFetchByLocation() {
		List<Team> teams = teamService.fetchTeamByLocation("Manchester");
		for (Team team : teams) {
			System.out.println(team);
		}
		assertEquals(teams.size(), 2);
	}
	
	@Autowired
	Player play;
	
	@Autowired
	PlayerService playService;
	
//	@Test
//	public void addPlayerUsingService() {
//		Player play = new Player();
//		play.setName("Kevin de Bruyne");
//		play.setAge(28);
//		play = playService.registerOrUpdatePlayer(play);
//		assertNotNull(play);
//	}
	
	@Test
	public void findByPlayNumUsingService() {
		int playNum = 62;
		assertNotNull(playService.findByPlayNum(playNum));
	}
	
//	@Test
//	public void deleteByPlayNumUsingService() {
//		int playNum = 2;
//		playService.deleteByPlayNum(playNum);
//		assertNull(playService.findByPlayNum(playNum));
//	}
	
	@Test
	public void checkFetchByAge() {
		List<Player> plays = playService.fetchPlayerByAge(28);
		for (Player player : plays) {
			System.out.println(player);
		}
		assertEquals(plays.size(), 4);
	}
	
	@Autowired
	Trophy trophy;
	
	@Autowired
	TrophyService trophyService;
	
//	@Test
//	public void addTrophyUsingService() {
//		Trophy tro = new Trophy();
//		tro.setTrophyName("Championship");
//		tro.setTrophyType(TrophyType.LEAGUE);
//		tro = trophyService.registerOrUpdateTrophy(tro);
//	}
	
	@Test
	public void findByTrophyNumUsingService() {
		int trophyNum = 65;
		assertNotNull(trophyService.findByTrophyNum(trophyNum));
	}
	
//	@Test
//	public void deleteByTrophyNumUsingService() {
//		int trophyNum = 4;
//		trophyService.deleteByTrophyNum(trophyNum);
//		assertNull(trophyService.findByTrophyNum(trophyNum));
//	}
	
	@Test
	public void checkFetchByTrophyType() {
		List<Trophy> trophies = trophyService.fetchTrophyByTrophyType(TrophyType.LEAGUE);
		for (Trophy trophy : trophies) {
			System.out.println(trophy);
		}
		assertEquals(trophies.size(), 1);
	}
	
	
	@Test
	public void manageAssociations() {
		Team t1 = new Team();
		t1.setName("West Ham");
		t1.setLocation("London");
		
		Team t2 = new Team();
		t2.setName("Southampton");
		t2.setLocation("Southhampton");
		
		Player play1 = new Player();
		play1.setName("Sergio Aguero");
		play1.setAge(31);
		
		Player play2 = new Player();
		play2.setName("Callum Wilson");
		play2.setAge(27);
		
		Trophy tr1 = new Trophy();
		tr1.setTrophyName("EFL Cup");
		tr1.setTrophyType(TrophyType.TOURNAMENT);
		
		Trophy tr2 = new Trophy();
		tr2.setTrophyName("League 1");
		tr2.setTrophyType(TrophyType.LEAGUE);
		
		// One to Many: one Team has many Players
		t1.getPlayers().add(play1);
		t1.getPlayers().add(play2);
		
		// Many to One for each Player to assign the Team
		play1.setCurrentTeam(t1);
		play2.setCurrentTeam(t1);
		
		// Many to Many
		t1.getTrophies().add(tr1);
		t1.getTrophies().add(tr2);
		t2.getTrophies().add(tr1);
		
//		teamService.registerOrUpdateTeam(t1);
//		teamService.registerOrUpdateTeam(t2);
		
	}

}
