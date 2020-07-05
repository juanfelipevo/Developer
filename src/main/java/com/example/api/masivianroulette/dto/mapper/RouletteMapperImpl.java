package com.example.api.masivianroulette.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.api.masivianroulette.dto.RouletteDTO;
import com.example.api.masivianroulette.model.Roulette;

@Component
public class RouletteMapperImpl implements RouletteMapper{

	@Override
	public RouletteDTO entityToDto(Roulette roulette) {
		if(roulette == null) {
			return null;
		}
		RouletteDTO rouletteDto = new RouletteDTO();
		rouletteDto.setId(roulette.getId());
		rouletteDto.setState(roulette.getState());
		
		return rouletteDto;
	}

	@Override
	public Roulette dtoToEntity(RouletteDTO rouletteDto) {
		if(rouletteDto == null) {
			return null;
		}
		Roulette roulette = new Roulette();
		roulette.setId(rouletteDto.getId());
		roulette.setState(rouletteDto.getState());
		
		return roulette;
	}

	@Override
	public List<RouletteDTO> entitiesToDtos(List<Roulette> roulettes) {
		if(roulettes == null) {
			return null;
		}
		List<RouletteDTO> rouletteDtos = new ArrayList<RouletteDTO>();
        for ( Roulette roulette : roulettes ) {
        	rouletteDtos.add( entityToDto( roulette ) );
        }
        
		return rouletteDtos;
	}

	@Override
	public List<Roulette> dtosToEntities(List<RouletteDTO> rouletteDtos) {
		if(rouletteDtos == null) {
			return null;
		}
		List<Roulette> roulettes = new ArrayList<Roulette>();
        for ( RouletteDTO roulette : rouletteDtos ) {
        	roulettes.add( dtoToEntity( roulette ) );
        }
		return roulettes;
	}

}
