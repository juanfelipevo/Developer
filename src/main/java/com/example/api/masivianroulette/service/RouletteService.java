package com.example.api.masivianroulette.service;

import java.util.List;

import com.example.api.masivianroulette.dto.BetDTO;
import com.example.api.masivianroulette.dto.RouletteDTO;

public interface RouletteService {

	Long addRoulette();
	
	String openRoulette(Long roulette) throws Exception;
	
	 List<BetDTO> closeRoulette(Long idRoulette) throws Exception;

	 void placeBet(String betColour, int betNumber, double betMoney,Long idRoulette, Long idUser) throws Exception;

	List<RouletteDTO> consultListRoulettes();
}
