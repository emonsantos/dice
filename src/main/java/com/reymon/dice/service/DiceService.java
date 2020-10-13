package com.reymon.dice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reymon.dice.Defaults;
import com.reymon.dice.entity.Dice;
import com.reymon.dice.entity.DiceSideDistribution;
import com.reymon.dice.entity.RollSum;
import com.reymon.dice.repository.DiceRepository;
import com.reymon.dice.repository.DiceSideDistributionRepository;

@Service
public class DiceService {
	
	@Autowired
	DiceRepository diceRepository;
	
	@Autowired
	DiceSideDistributionRepository diceSideRepository;
	
	public Dice rollDice(){
		Dice dice = new Dice(Defaults.NO_OF_PIECE, Defaults.NO_OF_SIDE, Defaults.NO_OF_ROLLS);
		//List<RollSum> rolls = rollDice(dice);
		return rollDice(dice);
	}
	
	public Dice rollDice(Dice dice){
		HashMap<Integer, Integer> rolls = new HashMap<Integer, Integer>();
		
		for(int i = 1; i <= dice.getNoOfRolls(); i++) {
			Integer rollSum = 0;
			Random random = new Random();
			
			for(int x = 1; x <= dice.getNoOfPiece(); x++) {
				rollSum += random.nextInt(dice.getNoOfSide()) + 1;
			}
			
			if(rolls.containsKey(rollSum)) {
				rolls.put(rollSum, rolls.get(rollSum) + 1);
			}else {
				rolls.put(rollSum, 1);
			}
		}
		
		List<RollSum> rollSum = new ArrayList<RollSum>();
		
		rollSum = rolls.entrySet()
					.stream()
					.map(m -> new RollSum(m.getKey(), m.getValue()))
					.collect(Collectors.toList());
		
		if(rollSum.size() > 0) {
			dice.setRollSum(rollSum);
			diceRepository.save(dice);
		}
		
		return dice;
	}
	
	public List<DiceSideDistribution> getDiceDistribution(Integer noOfPiece, Integer noOfSide) {
		return diceSideRepository.getDistribution(noOfPiece, noOfSide);
	}
	
	public List<Map<Integer, Integer>> getTotalSimulations() {
		return diceSideRepository.getTotalSimulations();
	}
	
}
