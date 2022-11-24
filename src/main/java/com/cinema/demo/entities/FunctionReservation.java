package com.cinema.demo.entities;

import java.util.ArrayList;
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

@Entity(name="function_reservation")
public class FunctionReservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_fun_res")
	private Long id;
	
	
	@JsonIgnoreProperties({"funReservation","hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_use")
	private MyUser myUser;
	
	@JsonIgnoreProperties({"reservationFuntions","hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_fuc")
	private FunctionMovie functionMovie;
	
	
	@JsonIgnoreProperties({"functionReservation","hibernateLazyInitializer","handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "functionReservation")
	private List<FunctionChair> functionChairs = new ArrayList<FunctionChair>();

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FunctionMovie getFunctionMovie() {
		return functionMovie;
	}

	public MyUser getMyUser() {
		return myUser;
	}

	public void setMyUser(MyUser myUser) {
		this.myUser = myUser;
	}

	public void setFunctionMovie(FunctionMovie functionMovie) {
		this.functionMovie = functionMovie;
	}

	public List<FunctionChair> getFunctionChairs() {
		return functionChairs;
	}

	public void setFunctionChairs(List<FunctionChair> functionChairs) {
		this.functionChairs = functionChairs;
	}
	
	
	
}
