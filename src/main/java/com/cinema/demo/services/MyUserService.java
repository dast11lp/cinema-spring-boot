package com.cinema.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.demo.entities.MyUser;
import com.cinema.demo.repositories.MyUserRepository;

@Service
public class MyUserService {
	
	@Autowired
	private MyUserRepository myUserRepository;
	
	public MyUser findById (Long id) {
		return this.myUserRepository.findById(id).orElse(null);
	}
	
	public MyUser save(MyUser user) {
		this.myUserRepository.save(user);
		return user;
	}
	
	public void deleteById(Long id) {
		this.myUserRepository.deleteById(id);
	}
	
	public MyUser findByUser(String user) {
		MyUser userAux = this.myUserRepository.findByUsername(user).get();
		System.out.println("UserAux: " + userAux.getUsername());
		return userAux;
	}
}
