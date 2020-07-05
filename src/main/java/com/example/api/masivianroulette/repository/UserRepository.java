package com.example.api.masivianroulette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.masivianroulette.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
