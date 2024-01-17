package com.cinema.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cinema.demo.entities.FunctionChair;

public interface FunctionChairRepository extends JpaRepository<FunctionChair, Long>{
	@Query("SELECT fc FROM function_chair fc ORDER BY fc.id")
	List<FunctionChair> findAllOrder();
	
	@Query("SELECT fc from function_chair fc WHERE fc.numberChair = : numberChair ")
	FunctionChair findByNumberChair(@Param("numberChair") Long numberChair);
	
}
