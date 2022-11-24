package com.cinema.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "function_movie")
public class FunctionMovie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fuc")
	private Long id;

	@Column(name = "hour_time_mov")
	private String hour_tim;
	
	@JsonIgnoreProperties({ "movieFunctions", "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_mov")
	private Movie movie;
	
	@JsonIgnore
	@JsonIgnoreProperties({"functionMovie","hibernateLazyInitializer","handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "functionMovie")
	private List<FunctionReservation> reservationFuntions;
	
	@JsonIgnore
	@JsonIgnoreProperties({"functionMovie","hibernateLazyInitializer","handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "functionMovie")
	private List<FunctionChair> functionChairs;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHour_tim() {
		return hour_tim;
	}

	public void setHour_tim(String hour_tim) {
		this.hour_tim = hour_tim;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public List<FunctionReservation> getReservationFuntions() {
		return reservationFuntions;
	}

	public void setReservationFuntions(List<FunctionReservation> reservationFuntions) {
		this.reservationFuntions = reservationFuntions;
	}

	public List<FunctionChair> getFunctionChairs() {
		return functionChairs;
	}

	public void setFunctionChairs(List<FunctionChair> functionChairs) {
		this.functionChairs = functionChairs;
	}
	
}
