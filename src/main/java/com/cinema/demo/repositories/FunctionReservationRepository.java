package com.cinema.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.demo.entities.FunctionReservation;
import com.cinema.demo.entities.MyUser;

public interface FunctionReservationRepository extends JpaRepository<FunctionReservation, Long>{
	
	public List<FunctionReservation> findByMyUser(MyUser myUser);

}
