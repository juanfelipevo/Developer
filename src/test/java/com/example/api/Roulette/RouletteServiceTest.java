package com.example.api.Roulette;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.api.masivianroulette.config.DBConfiguration;
import com.example.api.masivianroulette.model.Roulette;
import com.example.api.masivianroulette.repository.RouletteRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=DBConfiguration.class)
public class RouletteServiceTest {

	@Autowired
	RouletteRepository rouletteRepository;

	@Test
	public void addRouletteTest() {
		Roulette roulette = new Roulette();
		roulette.setState("Closed");
		Roulette savedRoulette = rouletteRepository.save(roulette);
		Long savedRouletteId = savedRoulette.getId();
		assertTrue( savedRouletteId != null && savedRouletteId instanceof Long);
	}
	
}
