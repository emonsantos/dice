package com.reymon.dice.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.reymon.dice.entity.DiceSideDistribution;

public interface DiceSideDistributionRepository extends CrudRepository<DiceSideDistribution, Long>{

	@Query("SELECT e FROM diceSideDistribution e WHERE e.noOfPiece = :noOfPiece AND e.noOfSide = :noOfSide")
	public List<DiceSideDistribution> getDistribution(@Param(value = "noOfPiece") Integer noOfPiece, @Param(value = "noOfSide") Integer noOfSide);
	
	@Query(value = "SELECT no_of_piece, no_of_side, COUNT(dice_id) simulations, SUM(no_of_rolls) total_rolls  FROM dice GROUP BY no_of_piece, no_of_side", nativeQuery = true)
	public List<Map<Integer, Integer>> getTotalSimulations();
}
