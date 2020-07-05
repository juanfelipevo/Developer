package com.example.api.masivianroulette.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.api.masivianroulette.dto.UserDTO;
import com.example.api.masivianroulette.model.User;

@Mapper
public interface UserMapper {

	@Mapping(source="user.id", target="id")
	@Mapping(source="user.balance", target="balance")
	UserDTO entityToDto(User user);
	
	@Mapping(source="userDTO.id", target="id")
	@Mapping(source="userDTO.balance", target="balance")
	User dtoToEntity(UserDTO userDto);
	
	List<UserDTO> entitiesToDtos(List<User> users);
	
	List<User> dtosToEntities(List<UserDTO> userDtos);
}
