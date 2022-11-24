package com.cinema.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cinema.demo.entities.Movie;
import com.cinema.demo.repositories.MovieRepository;


@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRep;
	
	
	public List<Movie> findAll(){
		return this.movieRep.findAll();
	}
	
	public Movie findByid(Long id){
		
		Movie movie = this.movieRep.findById(id).orElse(null);
		
		return movie;
	}
}
