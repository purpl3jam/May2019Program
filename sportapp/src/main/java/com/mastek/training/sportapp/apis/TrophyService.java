package com.mastek.training.sportapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.sportapp.entities.Trophy;
import com.mastek.training.sportapp.entities.TrophyType;
import com.mastek.training.sportapp.repositories.TrophyRepository;

@Component
@Scope("prototype")
public class TrophyService {
	
	@Autowired
	private TrophyRepository trophyRepository;
	
	public TrophyService() {
		System.out.println("Trophy Service Created");
	}
	
	public Trophy registerOrUpdateTrophy(Trophy t) {
		t = trophyRepository.save(t);
		System.out.println("Trophy Registered " + t);
		
		return t;
	}
	
	public Trophy findByTrophyNum(int trophyNum) {
		try {
			return trophyRepository.findById(trophyNum).get();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Trophy> fetchTrophyByTrophyType(TrophyType type) {
		
		return trophyRepository.findByTrophyType(type);
	}

	public void deleteByTrophyNum(int trophyNum) {
		
		trophyRepository.deleteById(trophyNum);
	}
}
