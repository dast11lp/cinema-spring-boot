package com.cinema.demo.models;

import com.cinema.demo.entities.FunctionMovie;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_NULL)
public class Ticket {
	

    private Integer chair;
    private Long userId;
    private String username;
    private FunctionMovie functionMovie;

    
    
    public Ticket(Integer chair, Long userId, String username, FunctionMovie functionMovie) {
		this.chair = chair;
		this.userId = userId;
		this.username = username;
		this.functionMovie = functionMovie;
	}


	public Integer getChair() {
		return chair;
	}

	public void setChair(Integer chair) {
		this.chair = chair;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public FunctionMovie getFunctionMovie() {
		return functionMovie;
	}

	public void setFunctionMovie(FunctionMovie functionMovie) {
		this.functionMovie = functionMovie;
	}
    
	
    
	
}
