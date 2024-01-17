package com.cinema.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.demo.entities.Function;

public interface FunctionRepository extends JpaRepository<Function, Integer>{

}
