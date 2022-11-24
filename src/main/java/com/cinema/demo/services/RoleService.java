package com.cinema.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.demo.entities.MyUser;
import com.cinema.demo.entities.Role;
import com.cinema.demo.repositories.MyUserRepository;
import com.cinema.demo.repositories.RoleRepository;

@Service
public class RoleService{
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role findById (Long id) {
		return this.roleRepository.findById(id).orElse(null);
	}
	
	public void save(Role role) {
		this.roleRepository.save(role);
	}
	
	public void deleteById(Long id) {
		this.roleRepository.deleteById(id);
	}
}
