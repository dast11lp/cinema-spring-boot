package com.cinema.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.demo.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
