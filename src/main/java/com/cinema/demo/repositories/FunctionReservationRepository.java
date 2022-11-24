package com.cinema.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.demo.entities.FunctionReservation;

public interface FunctionReservationRepository extends JpaRepository<FunctionReservation, Long>{

}
