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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity(name = "users")
public class MyUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_use")
	private Long idUser;

	@Column(name = "username_use")
	private String username;

	@Column(name = "password_use")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_use")
	private List<Role> roles;
	
//	@JsonIgnoreProperties({"myUser","hibernateLazyInitializer","handler"})
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "myUser")
//	private List<Reservation> reservations;
	
	
	@JsonIgnoreProperties({"myUser","hibernateLazyInitializer","handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "myUser")
	private List<FunctionReservation> funReservation;
	
	
	
	@JsonIgnoreProperties({"myUser","hibernateLazyInitializer","handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "myUser")
	private List<Card> cards;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<FunctionReservation> getFunReservation() {
		return funReservation;
	}

	public void setFunReservation(List<FunctionReservation> funReservation) {
		this.funReservation = funReservation;
	}
	
	
	

}
