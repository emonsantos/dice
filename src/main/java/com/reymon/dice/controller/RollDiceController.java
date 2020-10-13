package com.reymon.dice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reymon.dice.entity.Dice;
import com.reymon.dice.service.DiceService;

@RestController
public class RollDiceController {

	@Autowired
	DiceService diceService;

	@SuppressWarnings("unchecked")

	@RequestMapping(value = "/rollDice", method = RequestMethod.POST, produces = "application/json")
	public <T> T rollDice() {
		T response = null;
		response = (T) diceService.rollDice();
		return response;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/rollDiceWithParam", method = RequestMethod.POST, produces = "application/json")
	public <T> T rollDiceWithParam(@Valid @RequestBody Dice dice) {
		T response = null;
		response = (T) diceService.rollDice(dice);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/distribution", method = RequestMethod.GET, produces = "application/json")
	public <T> T getDistribution(@RequestParam Integer noOfPiece, @RequestParam Integer noOfSide) {
		T response = null;
		response = (T) diceService.getDiceDistribution(noOfPiece, noOfSide);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/simulation", method = RequestMethod.GET, produces = "application/json")
	public <T> T getTotalSimulations() {
		T response = null;
		response = (T) diceService.getTotalSimulations();
		return response;
	}

}
