package com.example.api.masivianroulette.controller;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.api.masivianroulette.dto.BetDTO;
import com.example.api.masivianroulette.dto.Pojo;
import com.example.api.masivianroulette.dto.RouletteDTO;
import com.example.api.masivianroulette.service.RouletteService;
import com.example.api.masivianroulette.utils.Define;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api/roulette")
public class RouletteController {

	@Autowired
	RouletteService rouletteService;

	@GetMapping("/add")
	public ResponseEntity addRoulette() {
		rouletteService.addRoulette();
		return new ResponseEntity<>("{\"message\":\" " + Define.SUCCESS + "\"}", HttpStatus.OK);
	}

	@GetMapping("/open")
	public ResponseEntity<String> openRoulette(@RequestParam(name = "rouletteId") Long rouletteId) {
		try {
			String state = rouletteService.openRoulette(rouletteId);
			return new ResponseEntity<>("{\"state\":\" " + state + "\"}", HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("{\"error\":\" " + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("{\"error\":\" " + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/placeBet")
	public ResponseEntity<String> placeBet(@RequestBody Pojo pojo, @RequestHeader("idUser") Long idUser)
			throws Exception {
		try {
			rouletteService.placeBet(pojo.getColour(), pojo.getBetNumber(), pojo.getBetAmount(), pojo.getIdRoulette(),
					idUser);
			return new ResponseEntity<>("{\"message\":\" " + Define.SUCCESS + "\"}", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("{\"error\":\" " + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/closed")
	public ResponseEntity<String> closedRoulette(@RequestParam(name = "rouletteId") Long rouletteId) throws Exception {
		try {
			List<BetDTO> betList = rouletteService.closeRoulette(rouletteId);
			Gson json = new Gson();
			return new ResponseEntity<>(json.toJson(betList), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("{\"error\":\" " + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/consult")
	public ResponseEntity<String> consultRoulette() {
		try {
			List<RouletteDTO> RouletDtoList = rouletteService.consultListRoulettes();
			Gson json = new Gson();
			return new ResponseEntity<>(json.toJson(RouletDtoList), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("{\"error\":\" " + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
		}
	}

}
