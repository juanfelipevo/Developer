package com.example.api.masivianroulette.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.api.masivianroulette.dto.BetDTO;
import com.example.api.masivianroulette.model.Bet;

@Component
public class BetMapperImpl implements BetMapper {

	@Override
	public BetDTO entityToDto(Bet bet) {
		if(bet == null) {
			return null;
		}
		BetDTO betDTO = new BetDTO();
		betDTO.setAmount(bet.getAmount());
		betDTO.setBettor(bet.getBettor());
		betDTO.setColour(bet.getColour());
		betDTO.setNumber(bet.getNumber());
		betDTO.setId(bet.getId());
		betDTO.setRoulette(bet.getRoulette());
		
		return betDTO;
	}

	@Override
	public Bet dtoToEntity(BetDTO betDto) {
		if(betDto == null) {
			return null;
		}
		
		Bet bet = new Bet();
		bet.setAmount(betDto.getAmount());
		bet.setBettor(betDto.getBettor());
		bet.setColour(betDto.getColour());
		bet.setNumber(betDto.getNumber());
		bet.setId(betDto.getId());
		bet.setRoulette(betDto.getRoulette());
		
		return bet;
	}

	@Override
	public List<BetDTO> entitiesToDtos(List<Bet> bets) {
		if(bets == null) {
			return null;
		}
		List<BetDTO> betDtos = new ArrayList<BetDTO>();
		for ( Bet bet : bets ) {
			betDtos.add( entityToDto(bet) );
        }
		return betDtos;
	}

	@Override
	public List<Bet> dtosToEntities(List<BetDTO> betDtos) {
		if(betDtos == null) {
			return null;
		}
		List<Bet> bets = new ArrayList<Bet>();
		for ( BetDTO bet : betDtos ) {
			bets.add( dtoToEntity( bet ) );
        }
		return bets;
	}

}
