package com.cinema.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.demo.entities.Function;
import com.cinema.demo.repositories.FunctionRepository;

@Service
public class FunctionService{
	
	@Autowired 
	private FunctionRepository functionRepository;
	
	public List<Function> getFunctions () {
		return this.functionRepository.findAll();
	}
	
	public Function getFunction (int id) {
		return this.functionRepository.findById(id).orElse(null);
	}
}
