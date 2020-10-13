package com.reymon.dice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity()
@Table(name = "dice")
public class Dice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dice_id")
	private Integer diceId;
	@Min(1)
	@Column(name = "no_of_piece")
	private Integer noOfPiece;
	@Min(4)
	@Column(name = "no_of_side")
	private Integer noOfSide;
	@Min(1)
	@Column(name = "no_of_rolls")
	private Integer noOfRolls;
	
	@OneToMany(targetEntity = RollSum.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "dice_id")
	private List<RollSum> rollSum;
	
	@JsonIgnore
	public Integer getDiceId() {
		return diceId;
	}
	public void setDiceId(Integer diceId) {
		this.diceId = diceId;
	}
	public Integer getNoOfPiece() {
		return noOfPiece;
	}
	public void setNoOfPiece(Integer noOfPiece) {
		this.noOfPiece = noOfPiece;
	}
	public Integer getNoOfSide() {
		return noOfSide;
	}
	public void setNoOfSide(Integer noOfSide) {
		this.noOfSide = noOfSide;
	}
	public Integer getNoOfRolls() {
		return noOfRolls;
	}
	public void setNoOfRolls(Integer noOfRolls) {
		this.noOfRolls = noOfRolls;
	}
	public List<RollSum> getRollSum() {
		return rollSum;
	}
	public void setRollSum(List<RollSum> rollSum) {
		this.rollSum = rollSum;
	}
	public Dice(Integer noOfPiece, Integer noOfSide, Integer noOfRolls) {
		super();
		this.noOfPiece = noOfPiece;
		this.noOfSide = noOfSide;
		this.noOfRolls = noOfRolls;
	}
	public Dice() {
		super();
	}
	
}
