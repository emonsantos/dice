package com.reymon.dice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "diceSideDistribution")
@Table(name = "dice_side_distribution")
@Immutable
public class DiceSideDistribution {
	
	@Id
	private String Id;
	@Column(name = "no_of_piece")
	private Integer noOfPiece;
	@Column(name = "no_of_side")
	private Integer noOfSide;
	@Column(name = "side_sum")
	private Integer sideSum;
	@Column(name = "distribution")
	private Double distribution;
	@JsonIgnore
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
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
	public Integer getSideSum() {
		return sideSum;
	}
	public void setSideSum(Integer sideSum) {
		this.sideSum = sideSum;
	}
	public Double getDistribution() {
		return distribution;
	}
	public void setDistribution(Double distribution) {
		this.distribution = distribution;
	}
	
	

}
