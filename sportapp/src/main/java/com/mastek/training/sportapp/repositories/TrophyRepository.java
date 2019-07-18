package com.mastek.training.sportapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.mastek.training.sportapp.entities.Trophy;
import com.mastek.training.sportapp.entities.TrophyType;

@Component
public interface TrophyRepository extends CrudRepository<Trophy, Integer> {
	
	public List<Trophy> findByTrophyType (@Param("type") TrophyType type);
}
