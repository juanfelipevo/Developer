package com.example.api.masivianroulette.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.api.masivianroulette.model.Bet;

public interface BetRepository extends JpaRepository<Bet, Long>{

	
	/**
	 * Consulta que se encarga de traer los meses que tengan registro de informes
	 * @return
	 */
	@Query("SELECT B FROM Bet B WHERE B.roulette.id = :rouletteId ")
	List<Bet> searchBettingByRouletteId(@Param("rouletteId") Long rouletteId);
}
