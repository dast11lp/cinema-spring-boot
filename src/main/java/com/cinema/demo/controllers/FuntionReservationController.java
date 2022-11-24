package com.cinema.demo.controllers;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.demo.entities.Card;
import com.cinema.demo.entities.FunctionChair;
import com.cinema.demo.entities.FunctionMovie;
import com.cinema.demo.entities.FunctionReservation;
import com.cinema.demo.entities.Movie;
import com.cinema.demo.entities.MyUser;
import com.cinema.demo.models.Ticket;
import com.cinema.demo.repositories.FunctionChairRepository;
import com.cinema.demo.services.CardService;
import com.cinema.demo.services.FunctionMovieService;
import com.cinema.demo.services.FunctionReservationService;
import com.cinema.demo.services.MovieService;
import com.cinema.demo.services.MyUserService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("reservation/user/{idUser}")
@PreAuthorize("@securityService.hasUser(#idUser)")
@CrossOrigin({ "*" })
public class FuntionReservationController {

	private static final Logger log = LoggerFactory.getLogger(FuntionReservationController.class);

	@Autowired
	private FunctionReservationService funcResSer;

	@Autowired
	private MyUserService myUserService;

	@Autowired
	private FunctionMovieService funcMovSer;

	@Autowired
	private CardService cardService;
	
	@Autowired
	private FunctionChairRepository functionchairRepository;
	
	@PostMapping("/create-functionmovie/{idFunMov}/id-card/{idCard}")
	public ResponseEntity<?> create(@RequestBody FunctionChair functionChair, @PathVariable Long idUser,@PathVariable Long idFunMov, @PathVariable Long idCard) {

		MyUser user = this.myUserService.findById(idUser);
		if (user == null)
			return ResponseEntity.ok("el usuario no se encuentra en nuestros registros");

		Card card = this.cardService.findById(idCard);
		if (card == null)
			return ResponseEntity.ok("la tarjeta no se encuentra registrada");

		FunctionMovie funMovie = this.funcMovSer.findById(idFunMov);
		if (funMovie == null)
			return ResponseEntity.ok("la pélicula no se encuentra en los registros");

		FunctionMovie functiMovie = this.funcMovSer.findById(idFunMov);
		if (functiMovie == null)
			return ResponseEntity.ok("no existe registro de tal función");

		List<FunctionChair> listfunChairs = functiMovie.getFunctionChairs();
		if (listfunChairs == null || listfunChairs.isEmpty())
			return ResponseEntity.ok("la sala no registra sillas");

		System.out.println("test0");
		for (FunctionChair funChair : listfunChairs) {
			System.err.println(funChair.getId());
			if (funChair.getNumberChair().equals(functionChair.getNumberChair())) {
				if (funChair.getAvailable().equals(true)) {
					System.err.println("acá tambien");
					
					
					FunctionReservation funReservation = new FunctionReservation();
					
					funChair.setFunctionReservation(funReservation);
					funChair.setAvailable(false);
					
					this.funcResSer.save(funReservation);
					
					System.err.println("estoy por dentro "+funChair.getAvailable());
					
					this.functionchairRepository.save(funChair);
					

	
					funReservation.setMyUser(user);
			
					this.myUserService.save(user);
			
					Ticket ticketByUser = new Ticket(functionChair.getNumberChair(), user.getIdUser(),
							user.getUsername(), functiMovie);
			
					return ResponseEntity.ok(ticketByUser);
				}
			}

			}
		
		return ResponseEntity.ok("jejeje");
	}
	
	
	
	@GetMapping("list")
	public ResponseEntity<?> list(@PathVariable Long idUser ){
		return ResponseEntity.ok(this.funcResSer.findById((long) 26).getFunctionChairs());
	}


}
