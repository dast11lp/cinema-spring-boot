package com.cinema.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="function_chair")
public class FunctionChair {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_fun_cha")
	private Long id;
	
	@Column(name="number_cha")
	private Integer numberChair;
	
	@Column(name="available_fun_cha")
	private Boolean available;
	
	@JsonIgnore
	@JsonIgnoreProperties({"functionChairs","hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_fun_mov")
	private FunctionMovie functionMovie;
	
	@JsonIgnore
	@JsonIgnoreProperties({"funReservation","hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_fun_res")
	private FunctionReservation functionReservation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumberChair() {
		return numberChair;
	}

	public void setNumberChair(Integer numberChair) {
		this.numberChair = numberChair;
	}

	public FunctionMovie getFunctionMovie() {
		return functionMovie;
	}

	public void setFunctionMovie(FunctionMovie functionMovie) {
		this.functionMovie = functionMovie;
	}

	public FunctionReservation getFunctionReservation() {
		return functionReservation;
	}

	public void setFunctionReservation(FunctionReservation functionReservation) {
		this.functionReservation = functionReservation;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	
	
	
}
