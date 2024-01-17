package com.cinema.demo.models;

import java.util.List;

import com.cinema.demo.entities.FunctionChair;

public class Reservation {


	private Long idFunMov;

	private List<Long> functionChairs;

	public Long getIdFunMov() {
		return idFunMov;
	}

	public void setIdFunMov(Long idFunMov) {
		this.idFunMov = idFunMov;
	}

	public List<Long> getFunctionChairs() {
		return functionChairs;
	}

	public void setFunctionChairs(List<Long> functionChairs) {
		this.functionChairs = functionChairs;
	}

}
