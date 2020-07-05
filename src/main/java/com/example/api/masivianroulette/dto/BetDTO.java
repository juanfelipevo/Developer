package com.example.api.masivianroulette.dto;

import com.example.api.masivianroulette.model.Roulette;
import com.example.api.masivianroulette.model.User;

import lombok.Data;

@Data
public class BetDTO {
	
	private Long id;
	
	private int number;
	
	private String colour;
	
	private double amount;
	
	private Roulette roulette;
	
	private User bettor;

	public BetDTO( int number, String colour, double amount, Roulette roulette, User bettor) {
		super();
		this.number = number;
		this.colour = colour;
		this.amount = amount;
		this.roulette = roulette;
		this.bettor = bettor;
	}
	
	public BetDTO() {
		
	}
	
 
}
