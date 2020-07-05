package com.example.api.masivianroulette.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.api.masivianroulette.dto.UserDTO;
import com.example.api.masivianroulette.model.User;

@Component
public class UserMapperImpl implements UserMapper {

	@Override
	public UserDTO entityToDto(User user) {
		if(user == null) {
			return null;
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setBalance(user.getBalance());
		return userDTO;
	}

	@Override
	public User dtoToEntity(UserDTO userDto) {
		if(userDto == null) {
			return null;
		}
		User user = new User();
		user.setId(userDto.getId());
		user.setBalance(userDto.getBalance());
		return user;
	}

	@Override
	public List<UserDTO> entitiesToDtos(List<User> users) {
		if(users == null) {
			return null;
		}
		List<UserDTO> userDTO = new ArrayList<UserDTO>();
		 for ( User user : users ) {
			 userDTO.add( entityToDto( user));
	        }
		return userDTO;
	}

	@Override
	public List<User> dtosToEntities(List<UserDTO> userDtos) {
		if(userDtos == null) {
			return null;
		}
		List<User> users = new ArrayList<User>();
		for ( UserDTO userDTO : userDtos ) {
			users.add( dtoToEntity( userDTO ) );
        }
		return users;
	}

}
