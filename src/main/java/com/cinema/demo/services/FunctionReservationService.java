package com.cinema.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.demo.entities.Card;
import com.cinema.demo.entities.FunctionReservation;
import com.cinema.demo.repositories.CardRepository;
import com.cinema.demo.repositories.FunctionReservationRepository;

@Service
public class FunctionReservationService {
	
	@Autowired
	private FunctionReservationRepository funResRepo;
	
	
	public FunctionReservation findById(Long id) {
		return this.funResRepo.findById(id).orElse(null);
	}
	
	public List<FunctionReservation> findAll(){
		return this.funResRepo.findAll();
	}

	public void deleteById(Long id) {
		System.out.println("el id joder " + id);
		 this.funResRepo.deleteById(id);
	}
	
	public void save(FunctionReservation funRes) {
		this.funResRepo.save(funRes);
	}

}
