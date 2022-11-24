package com.cinema.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cinema.demo.entities.Movie;
import com.cinema.demo.services.MovieService;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/movies")
@CrossOrigin({"*"})
public class MovieController {
	
	private static final Logger log = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;
	

	@GetMapping("/list")
    public MappingJacksonValue getUserByName(){
        SimpleBeanPropertyFilter simpleBeanPropertyFilter =
                SimpleBeanPropertyFilter.serializeAllExcept("functionMovie");

        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("userFilter", simpleBeanPropertyFilter);

        List<Movie> movie = movieService.findAll();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(movie);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
}
