package com.example.api.masivianroulette.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.api.masivianroulette.dto.BetDTO;
import com.example.api.masivianroulette.dto.RouletteDTO;
import com.example.api.masivianroulette.dto.mapper.BetMapper;
import com.example.api.masivianroulette.dto.mapper.RouletteMapper;
import com.example.api.masivianroulette.exception.RouletteException;
import com.example.api.masivianroulette.model.Roulette;
import com.example.api.masivianroulette.model.User;
import com.example.api.masivianroulette.repository.BetRepository;
import com.example.api.masivianroulette.repository.RouletteRepository;
import com.example.api.masivianroulette.repository.UserRepository;
import com.example.api.masivianroulette.utils.ColourEnum;
import com.example.api.masivianroulette.utils.Define;
import com.example.api.masivianroulette.utils.StateEnum;

@Component
public class RouletteServiceImpl implements RouletteService {

	@Autowired
	private RouletteRepository rouletteRepository;
	@Autowired
	private RouletteMapper rouletteMapper;
	@Autowired
	private BetRepository betRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BetMapper betMapper;
	

	@Override
	public Long addRoulette() {
		RouletteDTO newRoulette = new RouletteDTO();
		newRoulette.setState(StateEnum.CLOSED.toString());
		Roulette savedRoulette = rouletteRepository.save(rouletteMapper.dtoToEntity(newRoulette));
		return savedRoulette.getId();
	}

	@Override
	public String openRoulette(Long rouletteId) throws Exception {
		Roulette roulette = new Roulette();
		roulette = rouletteRepository.findById(rouletteId).get();
		if (roulette.getState().equals(StateEnum.OPEN.toString())) {
			throw new NoSuchElementException(Define.ERROR_NOT_MATCH);
		}
		roulette.setState(StateEnum.OPEN.toString());
		rouletteRepository.save(roulette);
		return Define.SUCCESS_OPEN_ROULETTE;
	}

	@Override
	public void placeBet(String betColour, int betNumber, double betAmount,Long idRoulette, Long idUser) throws Exception {
			String validation = betValidations(betColour,betNumber,betAmount,idRoulette,idUser);
			User user = userRepository.findById(idUser).get();
			Roulette roulette = rouletteRepository.findById(idRoulette).get();
			if(!roulette.getState().equalsIgnoreCase(StateEnum.OPEN.toString())) {
				throw new RouletteException(Define.ERROR_ROULETTE_CLOSED);
			}
			if(validation != null) {
				throw new RouletteException(validation);
			}
			BetDTO betDTO = new BetDTO(betNumber,betColour,betAmount,roulette,user);
			betRepository.save(betMapper.dtoToEntity(betDTO));
	}
	
	public String betValidations(String betColour, int betNumber, double betAmount,Long idRoulette, Long idUser) {
		if (betColour != null && betNumber > 0) {
			return(Define.ERROR_INVALID_PARAMS);
		} else if (betAmount > 10000 || betAmount < 0) {
			return (Define.ERROR_INVALID_MONEY);
		} else if (betColour == null && betNumber < 0 || betNumber > 36) {
			return(Define.ERROR_INVALID_NUMBER);
		} else if (betNumber == 0 && !betColour.equalsIgnoreCase(ColourEnum.BLACK.toString()) && !betColour.equalsIgnoreCase(ColourEnum.RED.toString())) {
			return (Define.ERROR_INVALID_COLOUR);
		} else if(idUser == null) {
			return (Define.ERROR_MISSING_PARAMS);
		} else if(idRoulette == null) {
			return(Define.ERROR_MISSING_PARAMS);
		}
		return null; 
	}

	@Override
	public List<BetDTO> closeRoulette(Long idRoulette) throws Exception {
		Roulette roulette  = new Roulette();
		try {
			roulette = rouletteRepository.findById(idRoulette).get();
		} catch (Exception e) {
			throw new NoSuchElementException(Define.ERROR_NO_EXIST);
		}
		roulette.setState(StateEnum.CLOSED.toString());
		rouletteRepository.save(roulette);
		List<BetDTO> betDTOList = betMapper.entitiesToDtos(betRepository.searchBettingByRouletteId(idRoulette));
		return betDTOList;
	}

	@Override
	public List<RouletteDTO> consultListRoulettes() {
		List<RouletteDTO> roulletesList = rouletteMapper.entitiesToDtos(rouletteRepository.findAll());
		return roulletesList;
	}

}
