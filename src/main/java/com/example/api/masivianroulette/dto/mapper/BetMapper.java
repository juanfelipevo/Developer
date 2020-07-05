package com.example.api.masivianroulette.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.api.masivianroulette.dto.BetDTO;
import com.example.api.masivianroulette.model.Bet;


@Mapper(uses = {RouletteMapper.class, UserMapper.class})
public interface BetMapper {
	
	@Mapping(source="bet.id", target="id")
	@Mapping(source="bet.number", target="number")
	@Mapping(source="bet.colour", target="colour")
	@Mapping(source="bet.amount", target="amount")
	@Mapping(source="bet.roulette", target="roulette")
	@Mapping(source="bet.bettor", target="bettor")
	BetDTO entityToDto(Bet bet);
	
	@Mapping(source="betDTO.id", target="id")
	@Mapping(source="betDTO.number", target="number")
	@Mapping(source="betDTO.colour", target="colour")
	@Mapping(source="betDTO.amount", target="amount")
	@Mapping(source="betDTO.roulette", target="roulette")
	@Mapping(source="betDTO.bettor", target="bettor")
	Bet dtoToEntity(BetDTO betDto);
	
	List<BetDTO> entitiesToDtos(List<Bet> bets);
	
	List<Bet> dtosToEntities(List<BetDTO> betDtos);

}
