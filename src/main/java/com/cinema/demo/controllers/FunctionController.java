package com.cinema.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.demo.entities.Function;
import com.cinema.demo.services.FunctionService;

@RestController
@RequestMapping("functions")
public class FunctionController {

	@Autowired
	private FunctionService functionService;
	
	@GetMapping("list")
	public List<Function> getListFunctions () {
		
		List<Function> listFunctions = this.functionService.getFunctions();
		
		return listFunctions;
	} 
	
	@GetMapping("{id}")
	public Function Function (@PathVariable Integer id) {
		
		Function function = this.functionService.getFunction(id);
		
		
		return function;
	}
	
}
