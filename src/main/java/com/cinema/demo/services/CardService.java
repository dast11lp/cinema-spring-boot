package com.cinema.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.demo.entities.Card;
import com.cinema.demo.repositories.CardRepository;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRep;
	
	public Card findById(Long id) {
		Card card = this.cardRep.findById(id).orElse(null);

		return card;
	}
	
	public List<Card> findAll(){
		return this.cardRep.findAll();
	}

	public void deleteById(Long id) {
		System.out.println("el id joder " + id);
		 this.cardRep.deleteById(id);
	}
	
	public void save(Card card) {
		this.cardRep.save(card);
	}
}
