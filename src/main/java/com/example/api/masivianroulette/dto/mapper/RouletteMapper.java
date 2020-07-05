package com.example.api.masivianroulette.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.api.masivianroulette.dto.RouletteDTO;
import com.example.api.masivianroulette.model.Roulette;

@Mapper
public interface RouletteMapper {
	
	@Mapping(source="roulette.id", target="id")
	@Mapping(source="roulette.state", target="state")
	RouletteDTO entityToDto(Roulette roulette);
	
	@Mapping(source="rouletteDTO.id", target="id")
	@Mapping(source="rouletteDTO.state", target="state")
	Roulette dtoToEntity(RouletteDTO rouletteDto);
	
	List<RouletteDTO> entitiesToDtos(List<Roulette> roulettes);
	
	List<Roulette> dtosToEntities(List<RouletteDTO> rouletteDtos);
}
