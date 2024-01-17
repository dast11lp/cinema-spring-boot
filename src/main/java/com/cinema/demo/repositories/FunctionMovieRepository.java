package com.cinema.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.demo.entities.FunctionMovie;

public interface FunctionMovieRepository extends JpaRepository<FunctionMovie, Long>{
	
}
