package com.reymon.dice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "roll_sum")
public class RollSum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roll_sum_id")
	private Integer rollSumId;
	@Column(name = "dice_id")
	private Integer diceId;
	@Column(name = "side_sum")
	private Integer sideSum;
	@Column(name = "total_roll")
	private Integer totalRoll;

	@JsonIgnore
	public Integer getRollSumId() {
		return rollSumId;
	}
	public void setRollSumId(Integer rollSumId) {
		this.rollSumId = rollSumId;
	}
	@JsonIgnore
	public Integer getDiceId() {
		return diceId;
	}
	public void setDiceId(Integer diceId) {
		this.diceId = diceId;
	}
	public Integer getSideSum() {
		return sideSum;
	}
	public void setSideSum(Integer sideSum) {
		this.sideSum = sideSum;
	}
	public Integer getTotalRoll() {
		return totalRoll;
	}
	public void setTotalRoll(Integer totalRoll) {
		this.totalRoll = totalRoll;
	}
	public RollSum(Integer sideSum, Integer totalRoll) {
		super();
		this.sideSum = sideSum;
		this.totalRoll = totalRoll;
	}
	public RollSum() {
		super();
	}
	
	
}
