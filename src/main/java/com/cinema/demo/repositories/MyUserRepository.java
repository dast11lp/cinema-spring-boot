package com.cinema.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.demo.entities.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long>{
	
		public Optional<MyUser> findByUsername(String username);
}
