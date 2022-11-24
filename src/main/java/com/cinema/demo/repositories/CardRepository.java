package com.cinema.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.demo.entities.Card;

public interface CardRepository extends JpaRepository<Card, Long>{

}
