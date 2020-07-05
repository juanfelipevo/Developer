package com.example.api.masivianroulette.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "roulette")
public class Roulette {
	
	@Id
	@SequenceGenerator(name="roulette_id_seq", sequenceName="roulette_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roulette_id_seq")
	private Long id;
	
	@Column(name="state")
	private String state;

}
