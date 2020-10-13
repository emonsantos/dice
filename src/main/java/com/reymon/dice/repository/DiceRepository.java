package com.reymon.dice.repository;

import org.springframework.data.repository.CrudRepository;

import com.reymon.dice.entity.Dice;

public interface DiceRepository  extends CrudRepository<Dice, Long>{

}
