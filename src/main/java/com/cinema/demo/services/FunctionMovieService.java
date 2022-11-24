package com.cinema.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.demo.entities.FunctionMovie;
import com.cinema.demo.repositories.FunctionMovieRepository;

@Service
@Transactional
public class FunctionMovieService {
	
	@Autowired
	private FunctionMovieRepository functionMovieRep;
	
	@Transactional
	public List<FunctionMovie> list(){
		return this.functionMovieRep.findAll();
	}
	
	@Transactional
	public FunctionMovie findById(Long id) {
		return this.functionMovieRep.findById(id).orElse(null);
	}
	
	
	public List<FunctionMovie> findAll() {
		return this.functionMovieRep.findAll();
	}
	
	
	
}
