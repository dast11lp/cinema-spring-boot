package com.cinema.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.demo.entities.FunctionChair;
import com.cinema.demo.services.FunctionChairService;

@RestController
@RequestMapping("functionChair")
public class FunctionChairController {
	
	@Autowired 
	private FunctionChairService chairService;
	
	@GetMapping("chairsList")
	public List<FunctionChair> list() {
		return this.chairService.findAll();
	}
	
	@GetMapping("chair/{id}")
	public FunctionChair findById(@PathVariable Long id) {
		return this.chairService.findById(id);
	}
}
