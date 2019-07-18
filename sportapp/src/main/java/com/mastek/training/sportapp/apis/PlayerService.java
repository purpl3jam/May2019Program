package com.mastek.training.sportapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.sportapp.entities.Player;
import com.mastek.training.sportapp.repositories.PlayerRepository;

@Component
@Scope("prototype")
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	private PlayerService() {
		System.out.println("Player Service Created");
	}
	
	public Player registerOrUpdatePlayer(Player p) {
		p = playerRepository.save(p);
		System.out.println("Player Registered " + p);
		
		return p;
	}
	
	public Player findByPlayNum(int playNum) {
		try {
			return playerRepository.findById(playNum).get();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Player> fetchPlayerByAge(int age) {
		return playerRepository.findByAge(age);
	}
	
	public void deleteByPlayNum(int playNum) {
		playerRepository.deleteById(playNum);
	}

}
