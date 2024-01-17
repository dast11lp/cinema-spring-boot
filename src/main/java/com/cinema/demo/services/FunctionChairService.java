package com.cinema.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.demo.entities.FunctionChair;
import com.cinema.demo.repositories.FunctionChairRepository;

@Service
public class FunctionChairService {
	
	@Autowired
	private FunctionChairRepository chairRepository;
	
	public List<FunctionChair> findAll() {
		return this.chairRepository.findAll();
	}
	
	public FunctionChair findById (Long id) {
		return this.chairRepository.findById(id).orElse(null);
	}
	
	public List<FunctionChair>  saveAll(List<FunctionChair> listFunctionChair) {
		return this.chairRepository.saveAll(listFunctionChair);
	}
	
	public FunctionChair findByNumberChair (Long id) {
		return this.chairRepository.findByNumberChair(id);
	}
}
