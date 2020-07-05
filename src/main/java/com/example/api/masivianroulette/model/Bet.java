package com.example.api.masivianroulette.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
@Entity
@Table(name="bet")
public class Bet {
	
	@Id
	@SequenceGenerator(name="bet_id_seq", sequenceName="bet_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bet_id_seq")
	private Long id;
	
	@Column(name="number")
	private int number;
	
	@Column(name="colour")
	private String colour;
	
	@Column(name="amount")
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="roulette", foreignKey=@ForeignKey(name = "fk_roulette"),nullable=false)
	private Roulette roulette;
	
	@ManyToOne
	@JoinColumn(name="bettor", foreignKey=@ForeignKey(name = "fki_bettor"),nullable=false)
	private User bettor;
	
}
